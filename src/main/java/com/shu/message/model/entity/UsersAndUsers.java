package com.shu.message.model.entity;

import lombok.Data;

import java.util.Date;

@Data
public class UsersAndUsers {
    private Integer usersAndUsersId;

    private Integer usersId;

    private Integer otherUserId;

    private String otherUsername;

    private String otherUserImg;

    private Date createTime;

    private Date deleteTime;
}