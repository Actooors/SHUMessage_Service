package com.shumsg.model.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GroupMember {
    private String id;

    private String groupId;

    private String userId;

    private LocalDateTime createTime;

    private LocalDateTime deleteTime;

}