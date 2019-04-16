package com.shumsg.controller;

import com.shumsg.exception.AllException;
import com.shumsg.model.back.Result;
import com.shumsg.model.front.ModifyUserInfo;
import com.shumsg.service.UserService;
import com.shumsg.tools.JwtUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @program: shumsg
 * @description: 用户控制层
 * @author: 0GGmr0
 * @create: 2019-04-11 16:45
 */
@RestController
@Resource
@RequestMapping("/user")
public class UserController  {

    @Resource
    private UserService userService;

    @PutMapping("/info")
    public Result modifyUserInfo(@RequestBody ModifyUserInfo modifyUserInfo) throws AllException {

        return userService.modifyUserInfo(modifyUserInfo);
    }


    @GetMapping("/normal/{normalLoginId}")
    public Result verificationNormalLoginId(@PathVariable("normalLoginId") String normalLoginId) throws AllException {

        return userService.verifyUserNormalLoginId(normalLoginId);
    }

}
