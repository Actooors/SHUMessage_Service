package com.shumsg.model;

/**
 * @description: 常量存储类
 * @author: 0GGmr0
 * @create: 2019-04-10 21:31
 */
public final class UserConstRepository {
    private UserConstRepository() {}

    // 用户登录方式
    public static final String LOGIN_WITH_PHONE = "phone"; // 电话登录
    public static final String LOGIN_WITH_SCHOOL = "school"; // 学号登录
    public static final String LOGIN_WITH_NORMAL = "normal"; // 自定义账号密码登录

    // 用户身份
    public static final String STUDENT = "student"; // 学生
    public static final String OFFICIAL = "official"; // 官方账户
    public static final String ADMIN = "admin"; // 管理员
    public static final String SUPERADMIN = "superAdmin"; // 超级管理员
    public static final String SPIDER = "spider"; // 爬虫用户

    // 生成20位不重复密码所需的字母表
    public final static char[] ALPHABET = {'a','b','c','d','e','f','g','h','i',
                                            'j','k','l','m','n','o','p','q','r',
                                            's','t','u','v','w','x','y','z'};

    // 每年用户可以修改昵称的次数
    public final static int EDITABLE_NICKNAME_TIMES = 2;

    // TOKEN返回值
    public final static int SIGNATURE_VERIFICATION_EXCEPTION = -3; // token签名内容失效
    public final static int TOKEN_EXPIRED_EXCEPTION = -2; // token超时
    public final static int FAKE_TOKEN = -1; // 虚假token
    public final static int TEMPORARY_TOKEN = 1; // 临时token
    public final static int NORMAL_TOKEN = 2; // 正常token

    // TOKEN时间有效期
    public final static int TEMPORARY_TOKEN_VALIDITY_MINUTE = 15; // 临时token的有效期---分钟
    public final static int NORMAL_TOKEN_VALIDITY_DAY = 36500; // 正常token的有效期---天

    // 验证唯一性的两个标识符
    public final static int VERIFY_NORMAL_ID = 1; // 验证用户自定义登录账号唯一
    public final static int VERIFY_NICKNAME = 2; // 验证用户昵称唯一

    // 根据用户某信息查询用户的枚举
    public final static int SELECT_USER_BY_NORMAL_ID =  1; // 根据自定义账号登录
    public final static int SELECT_USER_BY_UUID =  2; // 根据UUID登录
    public final static int SELECT_USER_BY_NICKNAME =  3; // 根据昵称登录
    public final static int SELECT_USER_BY_STUDENT_CARD_ID =  4; // 根据学号登录

    // 设置新闻的发布格式
    public final static String MEDIA_TYPE_NEWS = "url"; // 新闻通过url格式
    public final static String MEDIA_TYPE_IMGS = "imgs"; // 新闻是通过图片格式

    // 根据标签uuid或名字查找标签的枚举
    public final static int SELECT_LABEL_BY_NAME = 1; // 通过标签名
    public final static int SELECT_LABEL_BY_UUID = 2; // 通过uuid

}
