package com.shumsg.exception;

/**
 * @description: 报错的基本操作内容
 * @author: 0GGmr0
 * @create: 2019-01-19 20:03
 */
public interface CommonError {

    Integer getErrCode();
    String getMsg();
    CommonError setErrMsg(String errMsg);
}
