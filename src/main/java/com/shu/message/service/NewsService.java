package com.shu.message.service;

import com.shu.message.dao.NewsMapper;
import com.shu.message.model.entity.News;
import com.shu.message.model.entity.NewsExample;
import com.shu.message.model.ov.Result;
import com.shu.message.model.ov.ResultSetting.NewsResponse;
import com.shu.message.model.ov.ResultSetting.NewsResponseInfo;
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

    /**
     * @Description: 获取新闻列表
     * @Param: [pageNum, pageSize]
     * @Return: com.shu.message.model.ov.Result
     * @Author: ggmr
     * @Date: 18-8-28
     */
    public Result getNewsList(int pageNum, int pageSize) {
        NewsExample example = new NewsExample();
        example.setStartRow(pageNum * pageSize);
        example.setPageSize(pageSize);
        List<News> list= newsMapper.selectByExample(example);
        if(list.isEmpty()) {
            return ResultTool.error("没有更多的新闻啦 别找啦");
        }
        List<NewsResponseInfo> resList = new LinkedList<>();
        int nums = 0;
        for(News news : list) {
            NewsResponseInfo res = new NewsResponseInfo();
            res.setAuthor(news.getWebNameId(), news.getWebName());
            res.setContent(news.getTitle());
            res.setExtraInfo("官方新闻");
            res.setInfo(news.getNewsId());
            res.setShareInfo(news.getLikeNum(), news.getCommentNum(), news.getSharesNum());
            res.setTopic(news.getTagId(), news.getTag());
            res.setUrl(news.getUrl());
            resList.add(res);
            nums++;
        }
//        NewsResponse n = new NewsResponse(resList, nums);
        NewsResponse n = new NewsResponse();
        n.setCards(resList);
        n.setNums(nums);
        return ResultTool.success(n);
    }


}
