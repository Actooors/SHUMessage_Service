package com.shu.message.model.ov.resultsetting;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @program: message
 * @description:
 * @author: ggmr
 * @create: 2018-08-28 19:08
 */

public class UserInfo {
    @JsonProperty("id")
    private String userId;
    @JsonProperty("avatar")
    private String avatar;
    @JsonProperty("name")
    private String name;

    public UserInfo(String userId, String avatar, String name) {
        this.userId = userId;
        this.avatar = "https://avatars2.githubusercontent.com/u/30586220?s=460&v=4";
        this.name = name;
    }
}
