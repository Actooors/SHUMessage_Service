package com.shu.message.controller;

import com.shu.message.model.ov.Result;
import com.shu.message.model.ov.resultsetting.CommentRequest;
import com.shu.message.service.CommentService;
import com.shu.message.tools.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: message
 * @description:
 * @author: ggmr
 * @create: 2018-08-28 23:13
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/comment")
@Api(description = "评论")
public class CommentController {
    @Resource
    private CommentService commentService;

    @GetMapping("/commentList")
    @ApiOperation(value = "获取评论列表", httpMethod = "GET")
    public Result getNewsList(@RequestParam(value = "type") int type,
                              @RequestParam(value = "id") int id,
                              @RequestParam(value = "page") int page,
                              @RequestParam(value = "limit") List<Integer> limit) {
        List<Integer> s = new LinkedList<>();
        s.add(2);
        s.add(3);
        return commentService.getCommentList(type, id, page, limit);
    }

    @PostMapping("/newComment")
    @ApiOperation(value = "评论/回复", httpMethod = "POST")
    public Result insertComment(@RequestHeader(value = "Authorization") String token,
                                @RequestBody CommentRequest commentRequest){
        String userId = JwtUtil.parseJwt(token);
        return commentService.insertComment(userId,commentRequest);
    }
}