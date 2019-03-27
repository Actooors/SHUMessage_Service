package com.shu.message.service;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.shu.message.dao.*;
import com.shu.message.model.entity.*;
import com.shu.message.model.ov.Result;
import com.shu.message.model.ov.resultsetting.*;
import com.shu.message.tools.AliMessage;
import com.shu.message.tools.MD5;
import com.shu.message.tools.ResultTool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;

import javax.annotation.Resource;
import javax.swing.*;
import java.util.LinkedList;
import java.util.List;

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
//            for(UserInterestedNewsInfo news : list) {
            for(Label label : labelList) {
//                str.append("0").append(",");
//                str.append(news.getNewsId()).append("|");
//                res.append(news.getTitle().length() > 10 ?
//                        news.getTitle().substring(0, 10) + "...\n"
//                        : news.getTitle() + "\n");
                if(label.getLabelName().length() + res.length() > 20) break;
                res.append(label.getLabelName()).append(",");
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
            SendSmsResponse response = aliMessage.sendSms(user.getPhone(), cou,res.toString().substring(0, res.length() - 1), "xx");
            log.info("短信接口返回的数据----------------");
            log.info("Code=" + response.getCode());
            log.info("Message=" + response.getMessage());
            log.info("RequestId=" + response.getRequestId());
            log.info("BizId=" + response.getBizId());

//            userInterestedNewsMapper.insert(new UserInterestedNews(str.toString(),  user.getUserId()));
        }
        return ResultTool.success("发送完毕");
    }
}
