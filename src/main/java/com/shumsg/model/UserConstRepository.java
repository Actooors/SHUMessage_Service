package com.shumsg.model;

/**
 * @program: shumsg
 * @description: 常量存储类
 * @author: 0GGmr0
 * @create: 2019-04-10 21:31
 */
public final class UserConstRepository {
    private UserConstRepository() {}

    // 用户登录方式
    public static final String LOGIN_WITH_PHONE = "phone";
    public static final String LOGIN_WITH_SCHOOL = "school";

    // 用户身份
    public static final String STUDENT = "student";
    public static final String OFFICIAL = "official";
    public static final String ADMIN = "admin";
    public static final String SUPERADMIN = "superAdmin";


}
