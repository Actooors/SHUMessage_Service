package com.shu.message.controller;

import com.shu.message.model.Json.LikeInfo;
import com.shu.message.model.Json.LoginInfo;
import com.shu.message.model.ov.Result;
import com.shu.message.service.UserService;
import com.shu.message.tools.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @program: message
 * @description:
 * @author: ggmr
 * @create: 2018-08-31 14:39
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/common")
@Api(description = "公用")
public class CommonController {
    @Resource
    private UserService userService;

    @PostMapping("/like")
    @ApiOperation(value = "点赞", httpMethod = "POST")
    public Result login(@RequestHeader(value = "Authorization") String token,
                        @RequestBody LikeInfo likeInfo) {
        String userId = JwtUtil.parseJwt(token);
        return userService.setLike(likeInfo,userId);
    }
}
