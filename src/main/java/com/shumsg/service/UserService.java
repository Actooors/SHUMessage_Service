package com.shumsg.service;
import java.util.HashMap;
import java.util.Random;

import com.aventrix.jnanoid.jnanoid.NanoIdUtils;
import com.shumsg.dao.UserMapper;
import com.shumsg.exception.AllException;
import com.shumsg.exception.EmAllException;
import com.shumsg.interceptor.UserContext;
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

    @Resource
    private JwtUtil jwtUtil;

    /**
     * @Description: 登录接口
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
     * @Author: 0GGmr0
     * @Date: 2019-04-12
     */
    public Result modifyUserInfo(ModifyUserInfo modifyUserInfo) throws AllException {


        User user = UserContext.getCurrentUser();
        modifyUserInfo.setId(user.getId());
        // 当用户企图修改昵称时
        boolean judge = false;
        if(modifyUserInfo.getNickname() != null) {
            int editableNicknameTimes = user.getEditableNicknameTimes();
            // 因为昵称每年只允许修改两次，如果用户现在的修改剩余次数已经没有了
            if(editableNicknameTimes == 0) {
                return ResultTool.error(400, "在今年内您已经没有修改昵称的次数了");
            } else {
                // TODO 如果用户修改了昵称，那么应该refresh token
                modifyUserInfo.setEditableNicknameTimes(editableNicknameTimes - 1);
                // 用户是临时token 需要更新一下他的token
                judge = user.getNickname() == null;
            }
        }

        // 当用户企图创建自己的登录账号和密码时
        if(modifyUserInfo.getNormalLoginId() != null) {
            if(user.getNormalLoginId()!= null &&
                    !user.getNormalLoginId().equals(modifyUserInfo.getNormalLoginId())) {
                return ResultTool.error(400, "您不能修改自己的账号");
            }
            Random random = new Random();
            String uuid = NanoIdUtils.randomNanoId(random, ALPHABET, 20);
            String dbPassword = HS256.encryptionPassword(modifyUserInfo.getPassword(), uuid);
            modifyUserInfo.setPassword(dbPassword);
            modifyUserInfo.setPasswordSalt(uuid);
        }

        try {
            userMapper.updateUserByModifyUserInfo(modifyUserInfo);
        }catch (RuntimeException e) {
            log.info("执行修改用户信息，错误{}", e.toString());
            throw new AllException(EmAllException.UPDATE_ERROR);
        }
        return ResultTool.success(judge ?
                new HashMap<String, String>(){{
                    put("token", jwtUtil.createJwt(user.getId(), modifyUserInfo.getNickname()));
                }} : null);
    }
    

    /**
     * @Description: 验证用户自定义账号是否已存在
     * @Author: 0GGmr0
     * @Date: 2019-04-13
     */
    public Result verifyUserNormalLoginId(String normalLoginId) throws AllException {
        User user;
        try {
            user = userMapper.selectUserByNormalLoginId(normalLoginId);
        } catch (Exception e) {
            log.info("在verifyUserNormalLoginId方法下验证用户自定义登录账号是否重复失败，失败原因是{}", e.toString());
            throw new AllException(EmAllException.SELECT_ERROR);
        }
        if(user != null) {
            return ResultTool.error(400, "用户已经存在");
        } else {
            return ResultTool.success("该账号可以使用");
        }
    }
    
    /**
     * @Description: 使用自定义账号密码登录
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
        return ResultTool.error(400, "密码错误");
    }

    /**
     * @Description: 使用上海大学学号登录
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
                        log.info("在login方法插入用户时出现错误，错误为 " + e.toString());
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
        loginResponse.setToken(jwtUtil.createJwt(
                userId, //学号
                nickname   //昵称
        ));
        return loginResponse;
    }
}
