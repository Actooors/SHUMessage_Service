package com.shumsg.tools;

import com.shumsg.model.back.Result;

import java.util.List;

/**
 * @description: 统一返回格式工具
 * @author: 0GGmr0
 * @create: 2019-04-10 18:28
 */
public class ResultTool {

    @SuppressWarnings("unchecked")
    public static Result success(List<Object> object){
        Result result = new Result();
        result.setCode(200);
        result.setData(object);
        return result;
    }


    @SuppressWarnings("unchecked")
    public static Result success(Object object){
        Result result = new Result();
        result.setCode(200);
        result.setData(object);
        return result;
    }


    public static Result success(){
        Result result = new Result();
        result.setCode(200);
        return result;
    }


    public static Result error(Integer code, String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMessage(msg);
        return result;
    }


    public static Result error(Integer code){
        Result result = new Result();
        result.setCode(code);
        return result;
    }
}
