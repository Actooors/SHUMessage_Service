package com.shu.message.service;

import com.shu.message.dao.NewsMapper;
import com.shu.message.dao.TopicMapper;
import com.shu.message.model.entity.messagepackage.MessageAbstract;
import com.shu.message.model.ov.Result;
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
    private TopicMapper topicMapper;

//    public Result findMessage(int type, int id) {
//        MessageAbstract o = new MessageAbstract();
//        if(type == 0) {
//            o = newsMapper.selectByPrimaryKey(id);
//        } else if(type == 1) {
//            o = topicMapper.selectByPrimaryKey(id);
//        }
//
//
//    }

}
