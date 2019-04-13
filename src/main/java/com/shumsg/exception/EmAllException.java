package com.shumsg.exception;



/**
 * @program: message
 * @description: 数据库mapper操作相关的错误
 * @author: 0GGmr0
 * @create: 2019-01-19 16:58
 */
public enum EmAllException implements CommonError {

    UN_KNOWN_ERROR(500, "出现未知错误"),

    // sql相关
    INSERT_ERROR(500, "插入数据失败"),

    SELECT_ERROR(500, "获取数据失败"),

    UPDATE_ERROR(500, "更新数据出错"),

    QUERY_TIME_OUT(500, "请求超时，请确定您是否使用校园网登录"),
    // token验证相关
    USER_AND_PASSWORD_BLANK_ERROR(400, "账号或密码不能为空"),

    NO_SUCH_USER(400, "不存在此账号的用户"),

    NO_SUCH_LOGIN_TYPE(400, "不存在这种登录方式"),

    PASSWORD_ERROR(400, "密码错误"),

    NO_LOGIN_AUTHORIZATION(400, "没有登录权限"),

    LOGIN_VERIFICATION_ERROR(500, "上海大学登录接口出现异常"),

    USER_AND_PASSWORD_ERROR(400, "输入密码账号或者密码错误"),

    TOKEN_PHASE_ERROR(500, "解析token出错"),

    FUNCTION_HAS_NOT_BEEN_DEVELOPED(500, "功能尚未开发完"),

    ;

    // 错误码
    private Integer code;

    // 错误信息
    private String msg;

    EmAllException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public Integer getErrCode() {
        return this.code;
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.msg = errMsg;
        return this;
    }

    @Override
    public String getMsg() {
        return this.msg;
    }

}
