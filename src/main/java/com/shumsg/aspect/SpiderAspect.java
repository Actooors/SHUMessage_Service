package com.shumsg.aspect;

import com.shumsg.exception.AllException;
import com.shumsg.exception.EmAllException;
import com.shumsg.interceptor.UserContext;
import com.shumsg.model.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


import static com.shumsg.model.UserConstRepository.SPIDER;

/**
 * @program: shumsg
 * @description: 为爬虫单独提供的接口的权限验证
 * @author: 0GGmr0
 * @create: 2019-04-16 20:52
 */
@Aspect
@Component
@Slf4j
public class SpiderAspect {

    @Pointcut("within(com.shumsg.service.SpiderService)")
    public void matchType() {}

    /**
     * @Description: 检查调用爬虫接口的用户是不是爬虫用户
     * @Author: 0GGmr0
     * @Date: 2019-04-16
     */
    @Before("matchType()")
    public void check() throws AllException {
        User user = UserContext.getCurrentUser();
        if(!SPIDER.equals(user.getIdentity())) {
            throw new AllException(EmAllException.SPIDER_FUNCTION_ERROR);
        }
    }

}
