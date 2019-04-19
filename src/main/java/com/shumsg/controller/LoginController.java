package com.shumsg.controller;

import com.shumsg.exception.AllException;
import com.shumsg.model.back.Result;
import com.shumsg.model.front.LoginInfo;
import com.shumsg.service.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @description: 登录控制器
 * @author: 0GGmr0
 * @create: 2019-04-11 16:47
 */
@CrossOrigin
@RestController
@RequestMapping("/login")
public class LoginController {

    @Resource
    private UserService userService;

    @PostMapping("")
    public Result login(@Validated @RequestBody LoginInfo loginInfo) throws AllException {
        return userService.login(loginInfo);
    }

}
