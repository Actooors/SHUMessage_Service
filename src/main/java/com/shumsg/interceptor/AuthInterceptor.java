package com.shumsg.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shumsg.dao.UserMapper;
import com.shumsg.model.back.Result;
import com.shumsg.model.entity.User;
import com.shumsg.tools.JwtUtil;
import com.shumsg.tools.ResultTool;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @program: shumsg
 * @description: 拦截器
 * @author: 0GGmr0
 * @create: 2019-04-13 21:45
 */
@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Resource
    private UserMapper userMapper;

    @Value("${server.servlet.context-path}")
    private String contextPath;

    private static final String LOGIN_URL =  "/login";
//    private static final String ADD_IFRAME = "/common";
    private static final String TOKEN_NAME = "Authorization";
    private static final String REQUEST_METHOD = "/OPTIONS";


    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws IOException {
        // 登陆接口不做拦截及解决跨域问题
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type,Content-Length, Authorization, Accept,X-Requested-With");
        response.setHeader("Access-Control-Allow-Methods","PUT,POST,GET,DELETE,OPTIONS");
        String requestUri = request.getRequestURI();
//        if (requestUri.equals(contextPath + ADD_IFRAME)
        if(requestUri.equals(contextPath + LOGIN_URL)
                || request.getMethod().equals(REQUEST_METHOD)) {
            response.setStatus(200);
            return true;
        }
        // TODO 暂时只做了一个很简单的TOKEN验证，只判断有无，不判断是否过期或者修改过某些内容，也没有吊销token的操作
        String token = request.getHeader(TOKEN_NAME);
        if(token == null) {
            returnErrorMessage(response);
            return false;
        }
        String uuid = JwtUtil.parseJwt(token.substring(7));
        User user = userMapper.selectUserByUUId(uuid);
        // 创建一个线程级的变量 专门存储user
        new UserContext(user);
        return true;
    }

    private void returnErrorMessage(HttpServletResponse response) throws IOException {
        Result result = ResultTool.error(401, "请登录后再访问页面");
        response.setContentType("application.yml/json;charset=utf-8");
        response.setStatus(200);
        PrintWriter out = response.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        String jsonOfRST = mapper.writeValueAsString(result);
        out.print(jsonOfRST);
        out.flush();
    }
}