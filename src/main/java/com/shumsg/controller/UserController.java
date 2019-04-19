package com.shumsg.controller;

import com.shumsg.exception.AllException;
import com.shumsg.model.back.Result;
import com.shumsg.model.front.ModifyUserInfo;
import com.shumsg.service.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import static com.shumsg.model.UserConstRepository.VERIFY_NICKNAME;
import static com.shumsg.model.UserConstRepository.VERIFY_NORMAL_ID;


/**
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
    public Result modifyUserInfo(@Validated @RequestBody ModifyUserInfo modifyUserInfo) throws AllException {

        return userService.modifyUserInfo(modifyUserInfo);
    }


    @GetMapping("/normal/{normalLoginId}")
    public Result verificationNormalLoginId(@PathVariable("normalLoginId") String normalLoginId) throws AllException {

        return userService.verifyUserInfoUnique(normalLoginId, VERIFY_NORMAL_ID);
    }

    @GetMapping("/nickname/{nickname}")
    public Result verificationNickname(@PathVariable("nickname") String nickname) throws AllException {

        return userService.verifyUserInfoUnique(nickname, VERIFY_NICKNAME);
    }

}
