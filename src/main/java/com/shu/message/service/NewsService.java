package com.shu.message.service;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aventrix.jnanoid.jnanoid.NanoIdUtils;
import com.shu.message.dao.*;
import com.shu.message.model.entity.*;
import com.shu.message.model.ov.Result;
import com.shu.message.model.ov.resultsetting.*;
import com.shu.message.tools.AliMessage;
import com.shu.message.tools.MD5;
import com.shu.message.tools.ResultTool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;

import javax.annotation.Resource;
import javax.swing.*;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * @program: message
 * @description:
 * @author: ggmr
 * @create: 2018-08-28 13:07
 */
@Service
@Slf4j
public class NewsService {

    @Resource
    private NewsMapper newsMapper;

    @Resource
    private CommentMapper commentMapper;

    @Resource
    private MessageService messageService;

    @Resource
    private UserService userService;

    @Resource
    private LikeMapper likeMapper;

    @Resource
    private UserMapper userMapper;

    @Resource
    private LabelMapper labelMapper;

    @Resource
    private UserInterestedNewsMapper userInterestedNewsMapper;

    @Resource
    private GroupMapper groupMapper;


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
            NewsResponseInfo res = messageService.findCommonMessage(0, news.getNewsId(), news.getUserId(), userId);
            res.setContent(news.getTitle());
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


    public Result getInterestedNews(String uuid, String userId) {
        UserInterestedNews userInterestedNews = userInterestedNewsMapper.selectByPrimaryKey(uuid);
        String labelContent = userInterestedNews.getContent();
        String[] labelList = labelContent.split(",");
        List<NewsResponseInfo> resList = new LinkedList<>();
        int nums = 0;
        for(String label : labelList) {
            List<News> rList = newsMapper.selectNewsByLabelId(Integer.parseInt(label));
            for(News news : rList) {
                NewsResponseInfo res = messageService.findCommonMessage(0, news.getNewsId(), news.getUserId(), userId);
                res.setContent(news.getTitle());
                int newsType = news.getType();
                if(newsType == 1) {
                    res.setMedia(newsType, news.getTitle(), news.getUrl());
                } else {
                    res.setMedia(newsType, news.getImageUrlList());
                }
                resList.add(res);
                nums++;
            }
        }
        return ResultTool.success(new NewsResponse(resList, nums));
    }



    public Result getNews(int type, int id, String userId) {
        if(type == 2) {
            Comment comment = commentMapper.selectByPrimaryKey(id);
            CommentInfo res = new CommentInfo();
            res.setInfo(type, id);
            res.setContent(comment.getContent());
            res.setImgs(comment.getImgUrl());
            res.setAuthor(userService.getUserInfoById(comment.getUserId()));
            res.setPublishTime(comment.getCreateTime());
            res.setShareInfo(comment.getLikeNum());
            LikeExample example = new LikeExample();
            example.createCriteria()
                    .andTypeEqualTo(type)
                    .andUserIdEqualTo(userId)
                    .andNewsIdEqualTo(comment.getCommentId());
            List<Like> l = likeMapper.selectByExample(example);
           res.setFootprint(!(l.isEmpty() || l.get(0).getIsLiked() == 2));
           return ResultTool.success(res);
        } else {
            News news = newsMapper.selectByPrimaryKey(id);
            int newsType = news.getType();
            NewsResponseInfo res = messageService.findCommonMessage(type, id, news.getUserId(), userId);
            if (newsType == 1) {
                res.setMedia(newsType, news.getTitle(), news.getUrl());
            } else {
                res.setMedia(newsType, news.getImageUrlList());
            }
            return ResultTool.success(res);
        }
    }

    /**
     * @Description: 对新闻或者动态或者评论点赞
     * @Param: [likeInfo, userId]
     * @Return: com.shu.message.model.ov.Result
     * @Author: ggmr
     * @Date: 18-8-31
     */
    public Result sendMsg() throws ClientException {

        UserExample example = new UserExample();
        example.createCriteria()
                .andUserIdIsNotNull();
        List<User> users = userMapper.selectByExample(example);

        if(users.isEmpty()) return ResultTool.error("没有用户");
        for(User user : users) {
            // 对每一个user，查找他关注了哪些标签
            log.info(user.getUserId());
//            List<UserInterestedNewsInfo> list = newsMapper
//                    .selectMessageListByUserId(user.getUserId());
//            if(list.isEmpty()) continue;

            // 找到有新闻的标签并排序好
            List<Label> labelList = labelMapper.getLabels(user.getUserId());
            if(labelList.isEmpty()) continue;
            StringBuilder res = new StringBuilder();
            StringBuilder str = new StringBuilder();
            for(Label label : labelList) {
//            for(UserInterestedNewsInfo news : list) {
//                str.append("0").append(",");
//                str.append(news.getNewsId()).append("|");
//                res.append(news.getTitle().length() > 10 ?
//                        news.getTitle().substring(0, 10) + "...\n"
//                        : news.getTitle() + "\n");
                if(!(label.getLabelName().length() + res.length() > 20)) {
                    res.append(label.getLabelName()).append(",");
                } else {
                    res.append("等");
                }
                str.append(label.getLabelId()).append(",");
            }
            log.info(res.toString());
//            List<UserInterestedNewsInfo> newsList = newsMapper.selectMessageListByUserId(user.getUserId());
            List<Integer> newsList = labelMapper.getLabelNum(user.getUserId());
            Integer cou = 0;
            for(Integer one : newsList) {
                cou += one == null ? 0 : one;
            }
            log.info(user.getUserName() + cou.toString());

//            StringBuilder str = new StringBuilder();
//            for(UserInterestedNewsInfo news : newsList) {
//                str.append("0").append(",");
//                str.append(news.getNewsId()).append("|");
//            }
//            String tmp = str.toString();
//            String tmp1 = res.toString();
//            log.info(tmp1);
            AliMessage aliMessage = new AliMessage();
//            String uuid = UUID.randomUUID().toString();
//            log.info(uuid);
            // Use a faster, but non-secure, random generator
            Random random = new Random();
            // Use a custom alphabet containing only a, b, and c
            char[] alphabet = {'a','b','c','d','e','f','g','h','i',
                               'j','k','l','m','n','o','p','q','r',
                               's','t','u','v','w','x','y','z'};
            String uuid = NanoIdUtils.randomNanoId(random, alphabet, 20); // "babbcaabcb"
//            String uuid = NanoIdUtils.randomNanoId();
            SendSmsResponse response = aliMessage.sendSms(
                    user.getPhone(), cou,res.toString().substring(0, res.length() - 1), uuid);
            log.info("短信接口返回的数据----------------");
            log.info("Code=" + response.getCode());
            log.info("Message=" + response.getMessage());
            log.info("RequestId=" + response.getRequestId());
            log.info("BizId=" + response.getBizId());
            UserInterestedNews userInterestedNews = new UserInterestedNews();
            userInterestedNews.setContent(str.toString().substring(0, str.length() - 1));
            userInterestedNews.setUserInterestedNewsId(uuid);
            try {
                userInterestedNewsMapper.insert(userInterestedNews);
            } catch (DataAccessException e) {
                // TODO 之后应该抽象函数出来，然后重复调用
                log.info(e.toString());
            }
        }
        return ResultTool.success("发送完毕");
    }


    /**
     * @Description: 查询一个圈子的所有消息
     * @Param: [groupId]
     * @Return: com.shu.message.model.ov.Result
     * @Author: 0GGmr0
     * @Date: 2019-03-28
     */
    public Result getGroupMessageList(int groupId, String userId) {
        Group group = groupMapper.selectByPrimaryKey(groupId);
        NewsExample example = new NewsExample();
        example.setOrderByClause("`create_date` DESC");
//        example.setOrderByClause("`like_num` DESC");
        example.createCriteria().andTagEqualTo(group.getGroupsName());
        List<News> list = newsMapper.selectByExample(example);

        List<NewsResponseInfo> resList = new LinkedList<>();
        int nums = 0;
        for(News news : list) {
            NewsResponseInfo res = messageService.findCommonMessage(0, news.getNewsId(), news.getUserId(), userId);
            res.setContent(news.getTitle());
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

    /**
     * @Description: 返回圈子新闻列表，但是是按照点赞排序
     * @Param: [groupId, userId]
     * @Return: com.shu.message.model.ov.Result
     * @Author: 0GGmr0
     * @Date: 2019-03-28
     */
    public Result getGroupMessageListByLike(int groupId, String userId) {
        Group group = groupMapper.selectByPrimaryKey(groupId);
        NewsExample example = new NewsExample();
        example.setOrderByClause("`like_num` DESC");
//        example.setOrderByClause("`create_date` DESC");
        example.createCriteria().andTagEqualTo(group.getGroupsName());
        List<News> list = newsMapper.selectByExample(example);
        List<NewsResponseInfo> resList = new LinkedList<>();

        int nums = 0;
        for(News news : list) {
            NewsResponseInfo res = messageService.findCommonMessage(0, news.getNewsId(), news.getUserId(), userId);
            res.setContent(news.getTitle());
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
}
