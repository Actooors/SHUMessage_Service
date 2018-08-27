package com.shu.message.service;

import com.shu.message.dao.UserMapper;
import com.shu.message.model.Json.LoginInfo;
import com.shu.message.model.entity.User;
import com.shu.message.model.ov.Result;
import com.shu.message.model.ov.ResultSetting.LoginResponse;
import com.shu.message.tools.AuthTool;
import com.shu.message.tools.JwtUtil;
import com.shu.message.tools.ResultTool;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: message
 * @description:
 * @author: ggmr
 * @create: 2018-08-24 10:41
 */
@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    /**
     * @Description: 根据参数生成登录返回需要的信息
     * @Param: [userId, identity, userName]
     * @Return: com.shu.message.model.ov.resultsetting.LoginResponse
     * @Author: ggmr
     * @Date: 18-7-29
     */
    private LoginResponse setLoginResponse(String userId, String userName) {
        LoginResponse response = new LoginResponse();
        response.setToken(JwtUtil.createJwt(userId));
        response.setUserId(userId);
        response.setUserName(userName);
        return response;
    }

    /**
     * @Description: login接口的实现
     * @Param: [loginUser]
     * @Return: com.management.model.ov.Result
     * @Author: ggmr
     * @Date: 18-7-29
     */
    public Result login(LoginInfo loginUser) {
        //先判断账号和密码是否输入为空
        if(loginUser == null || loginUser.getUserId() == null || "".equals(loginUser.getUserId())
                || "".equals(loginUser.getPassword()) ||loginUser.getPassword() == null) {
            return ResultTool.error("账号或密码不能为空");
        }
        User existedUser = userMapper.selectByPrimaryKey(loginUser.getUserId());
        //如果该账户在数据库已经存在
        if (existedUser != null) {
            //如果该账户的账号密码验证正确并且可以登录
            if (AuthTool.getAuth(loginUser.getUserId(), loginUser.getPassword())) {
                return ResultTool.success(setLoginResponse(loginUser.getUserId(), existedUser.getUserName()));
                //如果密码输入错误
            } else if (!AuthTool.getAuth(loginUser.getUserId(), loginUser.getPassword())) {
                return ResultTool.error("密码输入错误");
                //如果该账户登录权限为禁止登陆
            } else {
                return ResultTool.error("您没有权限登录该系统");
            }
        } else {
            // 请求上海大学登陆接口查看有没有该用户，有的话该用户进入我们的数据库，没有的话返回登陆失败的信息
            if (AuthTool.getAuth(loginUser.getUserId(), loginUser.getPassword())) {
                User newUser = AuthTool.getInfo(loginUser.getUserId());
                //如果返回了newUser，说明操作正常
                if (newUser != null) {
                    userMapper.insert(newUser);
                    return ResultTool.success(setLoginResponse(loginUser.getUserId(), newUser.getUserName()));
                    //如果没有得到newUser，说明验证异常
                } else {
                    return ResultTool.error("验证过程中发生异常,一般是由于工号/学号无效!");
                }
                //直接去上海大学接口验证仍然发生了错误，说明账号或者密码输入错误
            } else {
                return ResultTool.error("账号或密码输入错误");
            }
        }

    }
}
