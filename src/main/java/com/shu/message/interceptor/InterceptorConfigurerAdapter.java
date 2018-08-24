package com.shu.message.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @program: message
 * @description:
 * @author: ggmr
 * @create: 2018-08-24 11:12
 */
@Configuration
public class InterceptorConfigurerAdapter implements WebMvcConfigurer {

    @Resource
    private AuthInterceptor authInterceptor;

    /**
     * @Description: 该方法用于注册拦截器，可注册多个拦截器，多个拦截器组成一个拦截器链
     * @Param: [registry]
     * @Return: void
     * @Author: ggmr
     * @Date: 18-7-31
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor).addPathPatterns("/**");
    }
}

