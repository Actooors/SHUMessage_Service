package com.shumsg.exception;

/**
 * @program: message
 * @description: 报错的基本操作内容
 * @author: 0GGmr0
 * @create: 2019-01-19 20:03
 */
public interface CommonError {

    public Integer getErrCode();
    public String getMsg();
    public CommonError setErrMsg(String errMsg);
}
