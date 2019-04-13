package com.shumsg.service;
import java.util.Random;

import com.aventrix.jnanoid.jnanoid.NanoIdUtils;
import com.shumsg.dao.UserMapper;
import com.shumsg.exception.AllException;
import com.shumsg.exception.EmAllException;
import com.shumsg.model.back.Result;
import com.shumsg.model.back.info.LoginResponse;
import com.shumsg.model.entity.User;
import com.shumsg.model.front.LoginInfo;
import com.shumsg.model.front.ModifyUserInfo;
import com.shumsg.tools.AuthTool;
import com.shumsg.tools.HS256;
import com.shumsg.tools.ResultTool;
import com.shumsg.tools.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import static com.shumsg.model.UserConstRepository.*;

/**
 * @program: shumsg
 * @description: 定义了用户相关的操作
 * @author: 0GGmr0
 * @create: 2019-04-10 21:49
 */
@Service
@Slf4j
public class UserService {

    @Resource
    private UserMapper userMapper;

    /**
     * @Description: 登录接口
     * @Param: [info]
     * @Return: com.shumsg.model.back.Result
     * @Author: 0GGmr0
     * @Date: 2019-04-12
     */
    public Result login(LoginInfo info) throws AllException {
        switch (info.getLoginType()) {
            case LOGIN_WITH_SCHOOL:
                return loginWithSchool(info);
            case LOGIN_WITH_NORMAL:
                return loginWithNormal(info);
            case LOGIN_WITH_PHONE:
                // TODO 暂时没有考虑电话登录方式
                throw new AllException(EmAllException.FUNCTION_HAS_NOT_BEEN_DEVELOPED);
            default:
                throw new AllException(EmAllException.NO_SUCH_LOGIN_TYPE);
        }
    }
    
    /**
     * @Description: 修改用户的个人信息
     * @Param: [id, modifyUserInfo]
     * @Return: com.shumsg.model.back.Result
     * @Author: 0GGmr0
     * @Date: 2019-04-12
     */
    public Result modifyUserInfo(String id, ModifyUserInfo modifyUserInfo) throws AllException {

        modifyUserInfo.setId(id);

        // TODO 过几天加了权限控制后切换成 ThreadLocal 来获取用户
        User user = userMapper.selectUserByUUId(id);

        // 当用户企图修改昵称时
        if(modifyUserInfo.getNickname() != null) {
            int editableNicknameTimes = user.getEditableNicknameTimes();
            // 因为昵称每年只允许修改两次，如果用户现在的修改剩余次数已经没有了
            if(editableNicknameTimes == 0) {
//                Date lastModifyNicknameTime = modifyUserInfo.getLastModifyNicknameTime();
//                Calendar cal = Calendar.getInstance();
//                int nowYear = cal.get(Calendar.YEAR);
//                cal.setTime(lastModifyNicknameTime);
//                int originalYear = cal.get(Calendar.YEAR)；
//                if (nowYear - originalYear == 0) {
//                }
                return ResultTool.error(400, "在今年内您已经没有修改昵称的次数了");
            } else {
                modifyUserInfo.setEditableNicknameTimes(editableNicknameTimes - 1);
            }
        }

        // 当用户企图创建自己的登录账号和密码时
        if(modifyUserInfo.getNormalLoginId() != null) {
            Random random = new Random();
            String uuid = NanoIdUtils.randomNanoId(random, ALPHABET, 20);
            String dbPassword = HS256.encryptionPassword(modifyUserInfo.getPassword(), uuid);
            modifyUserInfo.setPassword(dbPassword);
            modifyUserInfo.setPasswordSalt(uuid);
        }

        try {
            userMapper.updateUserByModifyUserInfo(modifyUserInfo);
        }catch (Exception e) {
            log.info("执行修改用户信息，错误{}", e.toString());
            throw new AllException(EmAllException.UPDATE_ERROR);
        }
        return ResultTool.success("数据更新成功");
    }



    /**
     * @Description: 使用自定义账号密码登录
     * @Param: [loginUser]
     * @Return: com.shumsg.model.back.Result
     * @Author: 0GGmr0
     * @Date: 2019-04-12
     */
    private Result loginWithNormal(LoginInfo loginUser) throws AllException {
        User user = userMapper.selectUserByNormalLoginId(loginUser.getUserId());
        if(user == null) {
            throw new AllException(EmAllException.NO_SUCH_USER);
        }

        if(HS256.encryptionPassword(loginUser.getPassword(), user.getPasswordSalt())
                .equals(user.getPassword())) {
            return ResultTool.success(
                    setLoginResponse(
                            user.getId(),
                            user.getStudentCardId(),
                            user.getActualName(),
                            user.getIdentity(),
                            user.getNickname()
                    ));
        }
        throw new AllException(EmAllException.PASSWORD_ERROR);
    }

    /**
     * @Description: 使用上海大学学号登录
     * @Param: [loginUser]
     * @Return: com.shumsg.model.back.Result
     * @Author: 0GGmr0
     * @Date: 2019-04-12
     */
    private Result loginWithSchool(LoginInfo loginUser) throws AllException {
        //先判断账号和密码是否输入为空
        if (loginUser.getUserId() == null || "".equals(loginUser.getUserId())
                || "".equals(loginUser.getPassword()) || loginUser.getPassword() == null) {
            throw new AllException(EmAllException.USER_AND_PASSWORD_BLANK_ERROR);
        }
        // 根据学号获取到用户
        User existedUser = userMapper.selectUserByStudentCardId(loginUser.getUserId());
        //如果该账户在数据库已经存在
        if (existedUser != null) {
            //如果该账户的账号密码验证正确并且可以登录
            boolean auth = AuthTool.getAuth(loginUser.getUserId(), loginUser.getPassword());
            if(!auth) {
                throw new AllException(EmAllException.QUERY_TIME_OUT);
            } else if (!existedUser.getInvalid()) {
                return ResultTool.success(
                        setLoginResponse(
                                existedUser.getId(),
                                existedUser.getStudentCardId(),
                                existedUser.getActualName(),
                                existedUser.getIdentity(),
                                existedUser.getNickname()
                        ));
                //如果密码输入错误
            } else {
                throw new AllException(EmAllException.NO_LOGIN_AUTHORIZATION);
            }
        } else {
            // 请求上海大学登陆接口查看有没有该用户，有的话该用户进入我们的数据库，没有的话返回登陆失败的信息
            if (AuthTool.getAuth(loginUser.getUserId(), loginUser.getPassword())) {
                User newUser = AuthTool.getInfo(loginUser.getUserId());
                //如果返回了newUser，说明操作正常
                if (newUser != null) {
                    try {
//                        newUser.setPassword(loginUser.getPassword());
                        // TODO 用户身份暂时统一设置为学生
                        newUser.setIdentity(STUDENT);
                        userMapper.insert(newUser);
                        log.info(newUser.getId());
                        return ResultTool.success(
                                setLoginResponse(
                                        newUser.getId(),
                                        newUser.getStudentCardId(),
                                        newUser.getActualName(),
                                        newUser.getIdentity(),
                                        newUser.getNickname()
                                ));
                    } catch (Exception e) {
                        log.info("插入用户时出现错误，错误为 " + e.toString());
                        throw new AllException(EmAllException.INSERT_ERROR);
                    }
                    //如果没有得到newUser，说明验证异常
                } else {
                    throw new AllException(EmAllException.INSERT_ERROR);
                }
                //直接去上海大学接口验证仍然发生了错误，说明账号或者密码输入错误
            } else {
                throw new AllException(EmAllException.USER_AND_PASSWORD_ERROR);
            }
        }
    }

    /**
     * @Description: 设置登录接口的返回信息
     * @Param: [userId, studentCardId, actualName, identity, nickname]
     * @Return: com.shumsg.model.back.info.LoginResponse
     * @Author: 0GGmr0
     * @Date: 2019-04-12
     */
    private LoginResponse setLoginResponse(String userId, String studentCardId, String actualName,
                                           String identity, String nickname) {
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setUserId(userId); // UUID
        loginResponse.setStudentCardId(studentCardId); // 工号
        loginResponse.setActualName(actualName); // 真实姓名
        loginResponse.setIdentity(identity); // 用户身份
        loginResponse.setToken(JwtUtil.createJwt(
                userId, //学号
                nickname   //昵称
        ));
        return loginResponse;
    }
}
