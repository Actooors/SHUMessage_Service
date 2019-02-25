package com.shu.message.model.entity;

import lombok.Data;

import java.util.Date;

@Data
public class UsersAndGroups {
    private Integer usersAndGroupsId;

    private Integer usersId;

    private Integer otherGroupId;

    private String otherGroupImg;

    private String otherGroupName;

    private Date createTime;

    private Date deleteTime;
}