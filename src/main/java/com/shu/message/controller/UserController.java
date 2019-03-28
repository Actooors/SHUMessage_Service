package com.shu.message.controller;

import com.shu.message.model.ov.Result;
import com.shu.message.model.ov.resultsetting.UserSpecialInfo;
import com.shu.message.service.UserService;
import com.shu.message.tools.JwtUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @program: message
 * @description: 用户层
 * @author: 0GGmr0
 * @create: 2019-03-28 00:46
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/info")
    public Result getUserInfo(@RequestHeader(value = "Authorization") String token) {
        String userId = JwtUtil.parseJwt(token);
        return userService.getUserInfo(userId);
    }

    @PostMapping("/concernOthers/{userId}")
    public Result concernOthers(@RequestHeader(value = "Authorization") String token,
                                @PathVariable(value = "userId") String otherUserId) {
        String userId = JwtUtil.parseJwt(token);
        return userService.concernOthers(userId, otherUserId);
    }

    @PostMapping("/cancelConcernOthers/{userId}")
    public Result cancelConcernOthers(@RequestHeader(value = "Authorization") String token,
                                @PathVariable(value = "userId") String otherUserId) {
        String userId = JwtUtil.parseJwt(token);
        return userService.cancleconcernOthers(userId, otherUserId);
    }


}
