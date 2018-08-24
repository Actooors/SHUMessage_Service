package com.shu.message.controller;

import com.shu.message.model.Json.LoginInfo;
import com.shu.message.model.ov.Result;
import com.shu.message.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @program: management
 * @description: 登录控制器
 * @author: ggmr
 * @create: 2018-07-29 17:17
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/login")
public class LoginController {
    @Resource
    private UserService userService;

    @PostMapping("")
    public Result login(@RequestBody LoginInfo loginInfo) {
        return userService.login(loginInfo);
    }
}
