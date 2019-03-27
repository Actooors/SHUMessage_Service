package com.shu.message.controller;

import com.aliyuncs.exceptions.ClientException;
import com.shu.message.model.ov.Result;
import com.shu.message.service.NewsService;
import com.shu.message.tools.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @program: message
 * @description:
 * @author: ggmr
 * @create: 2018-08-28 15:00
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/news")
@Api(description = "新闻")
public class NewsController {
    @Resource
    private NewsService newsService;

    @GetMapping("/newsList")
    @ApiOperation(value = "获取新闻列表", httpMethod = "GET")
    public Result getNewsList(@RequestHeader(value = "Authorization") String token,
                             @RequestParam(value = "page") int page,
                             @RequestParam(value = "pageSize") int pageSize) {
        String userId = JwtUtil.parseJwt(token);
        return newsService.getNewsList(page, pageSize, userId);
    }

    @GetMapping("/interestNews")
    public Result getInterestedNews() throws ClientException {
        return newsService.sendMsg();
    }

}
