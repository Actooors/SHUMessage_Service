package com.shumsg.controller;

import com.shumsg.exception.AllException;
import com.shumsg.model.back.Result;
import com.shumsg.service.SpiderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: shumsg
 * @description: 爬虫端控制器
 * @author: 0GGmr0
 * @create: 2019-04-16 21:17
 */
@RestController
@Resource
@RequestMapping("/spider")
public class SpiderController {

    @Resource
    private SpiderService spiderService;

    @GetMapping("test")
    public Result test() throws AllException {
        return spiderService.test();
    }
}
