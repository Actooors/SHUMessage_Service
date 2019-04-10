package com.shumsg.model.back.info;

import lombok.Data;

/**
 * @program: message
 * @description: 获取新闻列表时的做着信息
 * @author: 0GGmr0
 * @create: 2019-02-24 16:31
 */
@Data
public class UserInfo {
    private Integer id;
    private String avatar;
    private String name;

    public UserInfo(Integer userId, String avatar, String name) {
        this.id = userId;
        this.avatar = avatar;
        this.name = name;
    }
}

