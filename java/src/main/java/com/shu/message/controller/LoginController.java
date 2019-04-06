package com.shu.message.controller;

import com.shu.message.model.Json.LoginInfo;
import com.shu.message.model.ov.Result;
import com.shu.message.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;

/**
 * @program: management
 * @description: 登录控制器
 * @author: ggmr
 * @create: 2018-07-29 17:17
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/login")
@Api(description = "登陆")
public class LoginController {

    @Resource
    private UserService userService;

    @PostMapping("")
    @ApiOperation(value = "登陆", httpMethod = "POST")
    public Result login(@RequestBody LoginInfo loginInfo) throws UnsupportedEncodingException {
        return userService.login(loginInfo);
    }
}
