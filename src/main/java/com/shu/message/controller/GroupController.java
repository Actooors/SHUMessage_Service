package com.shu.message.controller;

import com.shu.message.model.ov.Result;
import com.shu.message.service.GroupService;
import com.shu.message.tools.JwtUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @program: message
 * @description:
 * @author: 0GGmr0
 * @create: 2019-03-28 01:26
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/group")
public class GroupController {


    @Resource
    private GroupService groupService;

    @GetMapping("/info")
    public Result getUserInfo(@RequestHeader(value = "Authorization") String token,
                              @RequestParam(value = "groupId") int groupId) {
        String userId = JwtUtil.parseJwt(token);
        return groupService.getGroupMessage(userId, groupId);
    }

    @PostMapping("/newGroup/{groupId}")
    public Result joinGroup(@RequestHeader(value = "Authorization") String token,
                              @PathVariable(value = "groupId") int groupId) {
        String userId = JwtUtil.parseJwt(token);
        return groupService.joinGroup(userId, groupId);
    }
}
