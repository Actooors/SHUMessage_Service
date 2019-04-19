package com.shumsg.controller;

import com.shumsg.exception.AllException;
import com.shumsg.exception.EmAllException;
import com.shumsg.model.back.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;


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
        } else if(ex instanceof MethodArgumentNotValidException){
            // 参数校验失败
            MethodArgumentNotValidException exception = (MethodArgumentNotValidException) ex;
            BindingResult res1 = exception.getBindingResult();
            final List<FieldError> fieldErrors = res1.getFieldErrors();
            StringBuilder builder = new StringBuilder();
            for (FieldError error : fieldErrors) {
                builder.append(error.getDefaultMessage()).append("\n");
            }
            result.setMessage(builder.toString());
            result.setCode(EmAllException.BAD_REQUEST.getErrCode());
        } else if(ex instanceof HttpMessageNotReadableException) {
            HttpMessageNotReadableException exception = (HttpMessageNotReadableException) ex;
            if(exception.getMessage().contains("java.util.Date")) {
                result.setMessage("时间格式有误");
            } else {
                result.setMessage(exception.getMessage());
            }
            result.setCode(EmAllException.BAD_REQUEST.getErrCode());
        } else {
            // 未知错误
            result.setCode(EmAllException.UN_KNOWN_ERROR.getErrCode());
            result.setMessage(EmAllException.UN_KNOWN_ERROR.getMsg());
        }
        return result;

    }
}
