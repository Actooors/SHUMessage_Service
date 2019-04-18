package com.shumsg.controller;

import com.shumsg.exception.AllException;
import com.shumsg.exception.EmAllException;
import com.shumsg.model.back.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @description: controller层异常处理类
 * @author: 0GGmr0
 * @create: 2019-04-10 19:48
 */
@ControllerAdvice
@Slf4j
public class HandlerException {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Result handler(Exception ex) {
        Result result  = new Result();
        if(ex instanceof AllException) {
            AllException exception = (AllException) ex;
            result.setCode(exception.getErrCode());
            result.setMessage(exception.getMsg());
        } else {
            // 未知错误
            result.setCode(EmAllException.UN_KNOWN_ERROR.getErrCode());
            result.setMessage(EmAllException.UN_KNOWN_ERROR.getMsg());
        }
        return result;

    }
}
