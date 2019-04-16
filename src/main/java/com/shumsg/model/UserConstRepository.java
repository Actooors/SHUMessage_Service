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
    public static final String LOGIN_WITH_NORMAL = "normal";

    // 用户身份
    public static final String STUDENT = "student";
    public static final String OFFICIAL = "official";
    public static final String ADMIN = "admin";
    public static final String SUPERADMIN = "superAdmin";

    // 生成20位不重复密码所需的字母表
    public final static char[] ALPHABET = {'a','b','c','d','e','f','g','h','i',
                                            'j','k','l','m','n','o','p','q','r',
                                            's','t','u','v','w','x','y','z'};

    // 每年用户可以修改昵称的次数
    public final static int EDITABLE_NICKNAME_TIMES = 2;

    // TOKEN返回值
    public final static int SIGNATURE_VERIFICATION_EXCEPTION = -3;
    public final static int TOKEN_EXPIRED_EXCEPTION = -2;
    public final static int FAKE_TOKEN = -1;
    public final static int TEMPORARY_TOKEN = 1;
    public final static int NORMAL_TOKEN = 2;

    // TOKEN时间有效期
    public final static int TEMPORARY_TOKEN_VALIDITY_MINUTE = 10;
    public final static int NORMAL_TOKEN_VALIDITY_DAY = 36500;
}
