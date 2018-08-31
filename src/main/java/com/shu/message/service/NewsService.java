package com.shu.message.service;

import com.shu.message.dao.CommentMapper;
import com.shu.message.dao.LikeMapper;
import com.shu.message.dao.NewsMapper;
import com.shu.message.dao.TopicMapper;
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
    private UserService userService;

    @Resource
    private NewsMapper newsMapper;

    @Resource
    private CommentMapper commentMapper;

    @Resource
    private TopicMapper topicMapper;

    @Resource
    private LikeMapper likeMapper;

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
            NewsResponseInfo res = new NewsResponseInfo();
            res.setAuthor(userService.getUserInfoById(news.getWebNameId()));
            res.setContent(news.getTitle());
            res.setExtraInfo("官方新闻");
            res.setInfo(news.getNewsId());
            res.setShareInfo(news.getLikeNum(), news.getCommentNum(), news.getSharesNum());
            res.setTopic(news.getTagId(), news.getTag());
            res.setPublishTime(news.getCreateDate());

            CommentExample example2 = new CommentExample();
            example2.createCriteria()
                    .andTypeEqualTo(0)
                    .andUserIdEqualTo(userId)
                    .andIdEqualTo(news.getNewsId());

            LikeExample example1 = new LikeExample();
            example1.createCriteria()
                    .andTypeEqualTo(0)
                    .andUserIdEqualTo(userId)
                    .andNewsIdEqualTo(news.getNewsId());

            TopicExample example3 = new TopicExample();
            example3.createCriteria()
                    .andTypeEqualTo(0)
                    .andUsreIdEqualTo(userId)
                    .andNewsIdEqualTo(news.getNewsId());

            res.setFootprint(
                    !likeMapper.selectByExample(example1).isEmpty(),
                    !commentMapper.selectByExample(example2).isEmpty(),
                    !topicMapper.selectByExample(example3).isEmpty()
            );
            int newsType = news.getType();
            if(newsType == 1) {
                res.setMedia(newsType, news.getTitle(), news.getUrl());
            } else {
                String ss = news.getImageUrlList();
                res.setMedia(newsType, news.getImageUrlList());
            }
            resList.add(res);
            nums++;
        }
        return ResultTool.success(new NewsResponse(resList, nums));
    }

}
