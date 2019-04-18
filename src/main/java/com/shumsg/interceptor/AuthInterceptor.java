package com.shumsg.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shumsg.model.back.Result;
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

import static com.shumsg.model.UserConstRepository.*;

/**
 * @description: 拦截器
 * @author: 0GGmr0
 * @create: 2019-04-13 21:45
 */
@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Resource
    private JwtUtil jwtUtil;

    @Value("${server.servlet.context-path}")
    private String contextPath;

    private static final String LOGIN_URL =  "/login";
//    private static final String ADD_IFRAME = "/common";
    private static final String TOKEN_NAME = "Authorization";
    private static final String REQUEST_METHOD = "/OPTIONS";
    private static final String MODIFY_USER_INFO = "/user/info";



    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws IOException {
        // 登陆接口不做拦截及解决跨域问题
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type,Content-Length, Authorization, Accept,X-Requested-With");
        response.setHeader("Access-Control-Allow-Methods", "PUT,POST,GET,DELETE,OPTIONS");
        String requestUri = request.getRequestURI();
        if (requestUri.equals(contextPath + LOGIN_URL)
                || request.getMethod().equals(REQUEST_METHOD)) {
            return true;
        }
        // TODO 暂时只做了一个很简单的TOKEN验证，只判断有无，不判断是否过期或者修改过某些内容，也没有吊销token的操作
        String token = request.getHeader(TOKEN_NAME);
        if (token == null) {
            returnErrorMessage(response, "请登录后再访问页面", 401);
            return false;
        } else {
            // 验证tokne是否是临时token
            switch (jwtUtil.validateToken(token)) {
                case SIGNATURE_VERIFICATION_EXCEPTION:
                    returnErrorMessage(response, "token签名内容失效", 401);
                    return false;
                case TOKEN_EXPIRED_EXCEPTION:
                    returnErrorMessage(response, "token已超时", 401);
                    return false;
                case FAKE_TOKEN:
                    returnErrorMessage(response, "虚假token", 401);
                    return false;
                case TEMPORARY_TOKEN:
                    if (requestUri.equals(contextPath + MODIFY_USER_INFO)) {
                        return true;
                    } else {
                        returnErrorMessage(response, "临时token不能访该url", 403);
                        return false;
                    }
                case NORMAL_TOKEN:
                    return true;
                default:
                    return true;
            }
        }
    }

    private void returnErrorMessage(HttpServletResponse response, String msg, int code) throws IOException {
        Result result = ResultTool.error(code, msg);
        response.setContentType("application.yml/json;charset=utf-8");
        response.setStatus(200);
        PrintWriter out = response.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        String jsonOfRST = mapper.writeValueAsString(result);
        out.print(jsonOfRST);
        out.flush();
    }
}