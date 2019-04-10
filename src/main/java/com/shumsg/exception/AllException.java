package com.shumsg.exception;

/**
 * @program: message
 * @description: 数据库操作相关错误
 * @author: 0GGmr0
 * @create: 2019-01-19 20:13
 */
public class AllException extends Exception implements CommonError {

    private CommonError commonError;

    // 直接接收EmSqlException的传参用于构造业务异常
    public AllException(CommonError commonError) {
        super();
        this.commonError = commonError;
     }

    // 接收自定义msg的方式构造异常
    public AllException(CommonError commonError, String msg) {
        super();
        this.commonError = commonError;
        this.commonError.setErrMsg(msg);
    }

    @Override
    public Integer getErrCode() {
        return this.commonError.getErrCode();
    }

    @Override
    public String getMsg() {
        return this.commonError.getMsg();
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.commonError.setErrMsg(errMsg);
        return this;
    }
}
