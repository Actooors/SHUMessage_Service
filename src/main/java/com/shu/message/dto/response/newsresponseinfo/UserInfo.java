package com.shu.message.dto.response.newsresponseinfo;

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
    //TODO 这里
    public UserInfo(Integer userId, String avatar, String name) {
        this.id = userId;
        this.avatar = "https://avatars2.githubusercontent.com/u/30586220?s=460&v=4";
        this.name = name;
    }
}

