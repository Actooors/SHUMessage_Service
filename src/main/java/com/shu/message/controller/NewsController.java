package com.shu.message.controller;

import com.shu.message.model.Json.LoginInfo;
import com.shu.message.model.ov.Result;
import com.shu.message.service.NewsService;
import com.shu.message.service.UserService;
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
    @ApiOperation(value = "获取新闻列表", httpMethod = "POST")
    public Result login(@RequestParam(value = "page") int page,
                        @RequestParam(value = "pageSize") int pageSize) {
        return newsService.getNewsList(page, pageSize);
    }
}
