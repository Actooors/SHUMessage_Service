package com.shumsg.model.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FollowRelation {
    private String id;

    private String userId;

    private String targetId;

    private String targetNickname;

    private String targetAvatar;

    private LocalDateTime createTime;

    private LocalDateTime deleteTime;
}