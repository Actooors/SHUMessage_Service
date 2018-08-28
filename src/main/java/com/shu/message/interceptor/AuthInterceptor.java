package com.shu.message.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shu.message.model.ov.Result;
import com.shu.message.model.ov.ResultCode;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @program: message
 * @description:
 * @author: ggmr
 * @create: 2018-08-24 11:11
 */
@Component
public class AuthInterceptor implements HandlerInterceptor {
    private static final String LOGIN_URL = "/api/login";
    private static final String TOKEN_NAME = "Authorization";
    private static final String REQUEST_METHOD = "OPTIONS";
    private static final int HTTP_CODE = 401;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        // 登陆接口不做拦截
        response.setHeader("Access-Control-Allow-Origin", "http://0.0.0.0:8888");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type,Content-Length, Authorization, Accept,X-Requested-With");
        response.setHeader("Access-Control-Allow-Methods","PUT,POST,GET,DELETE,OPTIONS");
        if (LOGIN_URL.equals(request.getRequestURI()) || request.getMethod().equals(REQUEST_METHOD)) {
            response.setStatus(200);
            return true;
        }
        if(request.getHeader(TOKEN_NAME) == null) {
            returnErrorMessage(response);
            return false;
        }
        return true;
    }

    private void returnErrorMessage(HttpServletResponse response) throws IOException {
        Result rst = new Result();
        rst.setCode(ResultCode.FAILED);
        rst.setMessage("请登录后再访问页面");
        response.setContentType("application/json;charset=utf-8");
        response.setStatus(HTTP_CODE);
        PrintWriter out = response.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        String jsonOfRST = mapper.writeValueAsString(rst);
        out.print(jsonOfRST);
        out.flush();
    }
}
