package com.shu.message.service;

import com.shu.message.dao.NewsMapper;
import com.shu.message.model.Json.pageInfo;
import com.shu.message.model.entity.News;
import com.shu.message.model.entity.NewsExample;
import com.shu.message.model.ov.Result;
import com.shu.message.model.ov.ResultSetting.NewsResponse;
import com.shu.message.tools.ResultTool;

import javax.annotation.Resource;
import java.util.*;

/**
 * @program: message
 * @description: 新闻相关的业务实现
 * @author: xw
 * @create: 2018-08-28 00:34
 */
public class NewService {

    @Resource
    private NewsMapper newsMapper;
    /**
     * @Description: 获取新闻列表，每页返回20条数据
     * @Param: {page:,pageSize:}
     * @Return:
     * @Author: xw
     * @Date: 18-8-28
     */
    public Result findNewsInfo(pageInfo pageInfo){
        Random rand = new Random();
        Integer page = pageInfo.getPage();
        Integer pageSize = pageInfo.getPageSize();
        NewsExample example = new NewsExample();
        example.createCriteria()
                .andMd5IdIsNotNull();
        List<News> news = newsMapper.selectByExample(example,(page-pageSize)*pageSize,pageSize);
        List<NewsResponse> newsInfoList = new ArrayList<>();
        for(News news1: news){
            NewsResponse newsResponse = new NewsResponse();
            newsResponse.setInfo(news1.getMd5Id());
            newsResponse.setTopic(news1.getTag());
            newsResponse.setContent(news1.getContent());
            newsResponse.setAuthor(news1.getWebName(),news1.getAuthor());
            newsResponse.setExtraInfo("官方新闻");
            newsResponse.setShareInfo(rand.nextInt(200),rand.nextInt(100),rand.nextInt(100));
            newsResponse.setUrl(news1.getUrl());
            newsInfoList.add(newsResponse);
        }
        Result<List<NewsResponse>> result = new Result<>();
        try{
            if(newsInfoList != null){
                result = ResultTool.success(newsInfoList);
            }
            else{
                result = ResultTool.error("找不到新闻信息！");
            }
            return result;
        }catch (Exception E){
            result = ResultTool.error("查询失败！");
            return result;
        }
    }
}
