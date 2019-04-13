package com.shumsg.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @program: shumsg
 * @description: 拦截器
 * @author: 0GGmr0
 * @create: 2019-04-13 22:51
 */
@Configuration
public class InterceptorConfigurerAdapter implements WebMvcConfigurer {

    @Resource
    private AuthInterceptor authInterceptor;

    /**
     * @Description: 该方法用于注册拦截器，可注册多个拦截器，多个拦截器组成一个拦截器链
     * @Author: ggmr
     * @Date: 2019-04-13
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor).addPathPatterns("/**");
    }
}
