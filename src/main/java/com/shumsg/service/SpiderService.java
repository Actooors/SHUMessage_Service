package com.shumsg.service;

import com.shumsg.exception.AllException;
import com.shumsg.model.back.Result;
import com.shumsg.tools.ResultTool;
import org.springframework.stereotype.Service;

/**
 * @program: shumsg
 * @description: 爬虫相关service
 * @author: 0GGmr0
 * @create: 2019-04-16 20:59
 */
@Service
public class SpiderService {

    public Result test() throws AllException {
        return ResultTool.success("dsd");
    }

}
