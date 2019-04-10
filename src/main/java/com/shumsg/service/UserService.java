package com.shumsg.service;

import com.shumsg.dao.UserMapper;
import com.shumsg.exception.AllException;
import com.shumsg.exception.EmAllException;
import com.shumsg.model.back.Result;
import com.shumsg.model.back.info.LoginResponse;
import com.shumsg.model.entity.User;
import com.shumsg.model.entity.UserMessage;
import com.shumsg.model.front.LoginInfo;
import com.shumsg.tools.AuthTool;
import com.shumsg.tools.ResultTool;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import static com.shumsg.model.ConstRepository.LOGIN_WITH_SCHOOL;

/**
 * @program: shumsg
 * @description: 定义了用户相关的操作
 * @author: 0GGmr0
 * @create: 2019-04-10 21:49
 */
@Service
public class UserService {

    @Resource
    private UserMapper userMapper;


    private LoginResponse setLoginResponse(Integer usersId, String studentId, String realName,
                                           Integer identity, String username) {
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setUsersId(usersId);
        loginResponse.setStudentId(studentId);
        loginResponse.setRealName(realName);
        loginResponse.setUsername(username);
        loginResponse.setIdentity(ConstCorrespond.USER_IDENTITY_STRING[identity]);
        loginResponse.setToken(jwtUtil.createJwt(
                studentId, //学号
                identity,  //用户身份
                realName,  //真实姓名
                usersId,   //用户对应数据库主键
                username   //用户昵称
        ));
        return loginResponse;
    }

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
            if (AuthTool.getAuth(loginUser.getUserId(), loginUser.getPassword()) &&
                    !existedUser.getInvalid()) {
                return ResultTool.success(
                        setLoginResponse(
                                existedUser.getUsersId(),
                                existedUser.getStudentId(),
                                existedUser.getRealName(),
                                existedUser.getIdentity(),
                                existedUser.getUsername()
                        ));
                //如果密码输入错误
            } else if (!AuthTool.getAuth(loginUser.getUserId(), loginUser.getPassword())) {
                throw new AllException(EmAllException.USER_AND_PASSWORD_ERROR);
                //如果该账户登录权限为禁止登陆
            } else {
                throw new AllException(EmAllException.NO_LOGIN_AUTHORIZATION);
            }
        } else {
            // 请求上海大学登陆接口查看有没有该用户，有的话该用户进入我们的数据库，没有的话返回登陆失败的信息
            if (AuthTool.getAuth(loginUser.getUserId(), loginUser.getPassword())) {
                Users newUser = AuthTool.getInfo(loginUser.getUserId());
                //如果返回了newUser，说明操作正常
                if (newUser != null) {
                    try {
                        newUser.setPassword(loginUser.getPassword());
                        usersMapper.insert(newUser);
                        return ResultTool.success(
                                setLoginResponse(
                                        newUser.getUsersId(),
                                        newUser.getStudentId(),
                                        newUser.getRealName(),
                                        ConstCorrespond.USER_IDENTITY,
                                        newUser.getUsername()
                                ));
                    } catch (Exception e) {
                        logger.info("插入用户时出现错误，错误为 " + e.toString());
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
}
