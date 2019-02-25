package com.shu.message.service;

import com.shu.message.dao.NewsMapper;
import com.shu.message.dao.UsersMapper;
import com.shu.message.dto.response.newsresponseinfo.*;
import com.shu.message.dto.response.NewsResponseInfo;
import com.shu.message.model.mapresult.UserNewsInfo;
import com.shu.message.exception.AllException;
import com.shu.message.exception.EmAllException;
import com.shu.message.model.entity.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: message
 * @description:
 * @author: 0GGmr0
 * @create: 2019-02-24 19:20
 */
@Service
public class NewsService implements BaseService {
    @Resource
    private NewsMapper newsMapper;

    @Resource
    private UsersMapper usersMapper;

    private Logger log = LoggerFactory.getLogger(this.getClass());

    public List<NewsResponseInfo> getNewsList(int pageNum, int pageSize) throws AllException {
        List<UserNewsInfo> newsList;
        try {
            newsList = newsMapper.selectNewsList(pageNum * pageSize, pageSize);
        } catch (Exception e) {
            log.info("查询新闻列表报错，错误信息为 " + e.toString());
            throw new AllException(EmAllException.SELECT_ERROR);
        }

        List<NewsResponseInfo> resList = new LinkedList<>();

        //TODO n+1问题需要解决
        for(UserNewsInfo news : newsList) {
            NewsResponseInfo res = new NewsResponseInfo();
            Users users = usersMapper.selectByUsersId(news.getUsersId());
            res.setAuthor(new UserInfo(users.getStudentId(), users.getUserImg(),users.getUsername()));
            // type id
            res.setInfo(new Info(0, news.getNewsId()));
            res.setPublishTime(news.getCreateTime());
            // TODO 这里需要和label表交互
            res.setTopic(new Topic(1, "资源动态"));
            // like comment share
            res.setShareInfo(new ShareInfo(news.getLikeNum(), news.getCommentNum(), news.getShareNum()));
            // TODO 这个似乎是写死的
            res.setExtraInfo("官方新闻");
            // TODO 设置用户是否点赞，评论，分享
            //依次是点赞，评论，转发
            res.setFootprint(new Footprint(
                    news.getLiked() == null ? false : news.getLiked(),
                    news.getCommented() == null ? false : news.getCommented(),
                    news.getShared() == null ? false : news.getShared()));
            res.setContent(news.getNewsName());

            int newsType = news.getType();
            if(newsType == 1) {
                res.setMedia(new Media(newsType, news.getNewsName(), news.getNewsUrl()));
            } else {
                res.setMedia(new Media(newsType, news.getImgUrl()));
            }
            resList.add(res);
        }
        return resList;
    }
}

