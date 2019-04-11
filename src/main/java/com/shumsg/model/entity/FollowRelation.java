package com.shumsg.model.entity;

import lombok.Data;

import java.util.Date;

@Data
public class FollowRelation {
    private String id;

    private String userId;

    private String targetId;

    private String targetNickname;

    private String targetAvatar;

    private Date createTime;

    private Date deleteTime;
}