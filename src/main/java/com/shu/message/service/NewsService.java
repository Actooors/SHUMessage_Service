package com.shu.message.service;

import com.shu.message.dao.NewsMapper;
import com.shu.message.model.entity.*;
import com.shu.message.model.ov.Result;
import com.shu.message.model.ov.resultsetting.NewsResponse;
import com.shu.message.model.ov.resultsetting.NewsResponseInfo;
import com.shu.message.tools.ResultTool;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: message
 * @description:
 * @author: ggmr
 * @create: 2018-08-28 13:07
 */
@Service
public class NewsService {

    @Resource
    private NewsMapper newsMapper;


    @Resource
    private MessageService messageService;

    /**
     * @Description: 获取新闻列表
     * @Param: [pageNum, pageSize]
     * @Return: com.shu.message.model.ov.Result
     * @Author: ggmr
     * @Date: 18-8-28
     */
    public Result getNewsList(int pageNum, int pageSize, String userId) {
        NewsExample example = new NewsExample();
        example.setOrderByClause("`create_date` DESC");
        example.setStartRow(pageNum * pageSize);
        example.setPageSize(pageSize);
        List<News> list= newsMapper.selectByExample(example);
        if(list.isEmpty()) {
            return ResultTool.error("没有更多的新闻啦 别找啦");
        }
        List<NewsResponseInfo> resList = new LinkedList<>();
        int nums = 0;
        for(News news : list) {
            NewsResponseInfo res = messageService.findCommonMessage(0, news.getNewsId(), userId);
            int newsType = news.getType();
            if(newsType == 1) {
                res.setMedia(newsType, news.getTitle(), news.getUrl());
            } else {
                res.setMedia(newsType, news.getImageUrlList());
            }
            resList.add(res);
            nums++;
        }
        return ResultTool.success(new NewsResponse(resList, nums));
    }

    public Result getNews(int type, int id, String userId) {
        NewsResponseInfo res = messageService.findCommonMessage(type, id, userId);
        News news = newsMapper.selectByPrimaryKey(id);
        int newsType = news.getType();
        if(newsType == 1) {
            res.setMedia(newsType, news.getTitle(), news.getUrl());
        } else {
            res.setMedia(newsType, news.getImageUrlList());
        }
        return ResultTool.success(res);
    }
}
