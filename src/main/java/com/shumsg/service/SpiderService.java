package com.shumsg.service;
import java.util.Date;
import java.util.HashMap;

import com.shumsg.dao.UserMapper;
import com.shumsg.exception.AllException;
import com.shumsg.exception.EmAllException;
import com.shumsg.model.back.Result;
import com.shumsg.model.entity.User;
import com.shumsg.model.front.SpiderUserInfo;
import com.shumsg.tools.ResultTool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import static com.shumsg.model.UserConstRepository.LOGIN_WITH_SCHOOL;
import static com.shumsg.model.UserConstRepository.OFFICIAL;

/**
 * @program: shumsg
 * @description: 爬虫相关service
 * @author: 0GGmr0
 * @create: 2019-04-16 20:59
 */
@Service
@Slf4j
public class SpiderService {

    @Resource
    private UserMapper userMapper;

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
        } catch (UnsupportedOperationException e) {
            log.info("爬虫端插入官方用户接口出错，错误信息为:{}",e.toString());
            throw new AllException(EmAllException.INSERT_ERROR);
        }
        return ResultTool.success(
                new HashMap<String, String>(){{
                    put("id", user.getId());
                }});
    }




}
