package com.shu.message.service;

import com.shu.message.dao.CommentMapper;
import com.shu.message.dao.LikeMapper;
import com.shu.message.dao.NewsMapper;
import com.shu.message.dao.TopicMapper;
import com.shu.message.model.entity.CommentExample;
import com.shu.message.model.entity.LikeExample;
import com.shu.message.model.entity.TopicExample;
import com.shu.message.model.entity.messagepackage.MessageAbstract;
import com.shu.message.model.ov.resultsetting.NewsResponseInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: message
 * @description:
 * @author: ggmr
 * @create: 2018-08-31 22:09
 */
@Service
public class MessageService {
    @Resource
    private NewsMapper newsMapper;

    @Resource
    private UserService userService;

    @Resource
    private TopicMapper topicMapper;

    @Resource
    private CommentMapper commentMapper;

    @Resource
    private LikeMapper likeMapper;


    private final static int NEWS = 0;
    private final static int TOPIC = 1;
    private final static String NEWS_EXINFO = "官方新闻";
    private final static String TOPIC_EXINFO = "动态";

    /**
     * @Description: 根据id和type查找信息的公共部分，type为0是新闻  type是1是动态
     * @Param: [type, id, userId]
     * @Return: com.shu.message.model.ov.Result
     * @Author: ggmr
     * @Date: 18-8-31
     */
    NewsResponseInfo findCommonMessage(int type, int id, String userId) {
        MessageAbstract o = new MessageAbstract();
        if(type == NEWS) {
            o = newsMapper.selectByPrimaryKey(id);
        } else if(type == TOPIC) {
            o = topicMapper.selectByPrimaryKey(id);
        }
        NewsResponseInfo res = new NewsResponseInfo();
        res.setAuthor(userService.getUserInfoById(userId));
        res.setInfo(type, id);
        res.setPublishTime(o.getCreateDate());
        res.setTopic(o.getTagId(), o.getTag());
        res.setShareInfo(o.getLikeNum(), o.getCommentNum(), o.getSharesNum());
        res.setExtraInfo(type == NEWS ? NEWS_EXINFO : TOPIC_EXINFO);
        CommentExample example2 = new CommentExample();
        example2.createCriteria()
                .andTypeEqualTo(type)
                .andUserIdEqualTo(userId)
                .andIdEqualTo(id);

        LikeExample example1 = new LikeExample();
        example1.createCriteria()
                .andTypeEqualTo(type)
                .andUserIdEqualTo(userId)
                .andNewsIdEqualTo(id);

        TopicExample example3 = new TopicExample();
        example3.createCriteria()
                .andTypeEqualTo(type)
                .andUserIdEqualTo(userId)
                .andNewsIdEqualTo(id);

        res.setFootprint(
                !likeMapper.selectByExample(example1).isEmpty(),
                !commentMapper.selectByExample(example2).isEmpty(),
                !topicMapper.selectByExample(example3).isEmpty()
        );
        return res;
    }

}
