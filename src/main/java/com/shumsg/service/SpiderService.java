package com.shumsg.service;
import java.util.HashMap;

import com.shumsg.dao.LabelMapper;
import com.shumsg.dao.NewsMapper;
import com.shumsg.dao.UserMapper;
import com.shumsg.exception.AllException;
import com.shumsg.model.back.Result;
import com.shumsg.model.entity.Label;
import com.shumsg.model.entity.News;
import com.shumsg.model.entity.User;
import com.shumsg.model.front.SpiderLabelInfo;
import com.shumsg.model.front.SpiderNewsInfo;
import com.shumsg.model.front.SpiderUserInfo;
import com.shumsg.tools.ResultTool;
import com.sun.org.apache.bcel.internal.generic.LADD;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import static com.shumsg.model.UserConstRepository.*;

/**
 * @description: 爬虫相关service
 * @author: 0GGmr0
 * @create: 2019-04-16 20:59
 */
@Service
@Slf4j
public class SpiderService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private NewsMapper newsMapper;

    @Resource
    private LabelMapper labelMapper;

    /**
     * @Description: 爬虫端插入官方用户的接口
     * @Author: 0GGmr0
     * @Date: 2019-04-16
     */
    public Result insertUser(SpiderUserInfo info) throws AllException {
        User user = new User();
        user.setNickname(info.getNickname());
        user.setIdentity(OFFICIAL);
        user.setInvalid(false);
        user.setAvatar(info.getAvatar());
        user.setRegisterWay(LOGIN_WITH_SCHOOL);
        try {
            userMapper.insert(user);
        } catch (DataAccessException e) {
            log.info("SpiderService -> insertUser接口出错，错误信息为:{}",e.toString());
            return ResultTool.error(400, e.toString());
        }
        return ResultTool.success(
                new HashMap<String, String>(){{
                    put("id", user.getId());
        }});
    }

    /**
     * @Description: 爬虫端插入新闻的接口
     * @Author: 0GGmr0
     * @Date: 2019-04-17
     */
    public Result insertNews(SpiderNewsInfo info) throws AllException {

        News news = new News();
        news.setUserId(info.getUserId());
        news.setMediaType(MEDIA_TYPE_NEWS);
        news.setMediaTitle(info.getMediaTitle());
        news.setNewsUrl(info.getNewsUrl());
        news.setNewsLabels(new String[] {info.getNewsLabelId()});
        news.setContentFromScrapy(info.getContentFromScrapy());
        news.setMd5(info.getMd5());
        news.setCreateTime(info.getCreateTime());
        try {
            newsMapper.insert(news);
        } catch (DataAccessException e) {
            log.info("SpiderService -> insertNews接口出错，错误信息为:{}",e.toString());
            return ResultTool.error(400, e.toString());
        }
        return ResultTool.success();
    }


    /**
     * @Description: 插入标签的接口
     * @Author: 0GGmr0
     * @Date: 2019-04-17
     */
    public Result insertLabel(SpiderLabelInfo info) throws AllException {
        try {
            // 标签未存在
            Label label;
            if((label = labelMapper.selectLabelByLabelInfo(info.getLabelName(), SELECT_LABEL_BY_NAME)) == null) {
                label = new Label();
                label.setName(info.getLabelName());
                labelMapper.insert(label);
            }
            String uuid = label.getId();
            return ResultTool.success(
                new HashMap<String, String>(){{
                    put("id", uuid);
            }});
        } catch (DataAccessException e) {
            log.info("SpiderService -> insertLabel接口出错，错误信息为:{}",e.toString());
            return ResultTool.error(400, e.toString());
        }
    }


}
