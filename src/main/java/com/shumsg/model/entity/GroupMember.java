package com.shumsg.model.entity;

import lombok.Data;

import java.util.Date;

@Data
public class GroupMember {
    private String id;

    private String groupId;

    private String userId;

    private Date createTime;

    private Date deleteTime;

}