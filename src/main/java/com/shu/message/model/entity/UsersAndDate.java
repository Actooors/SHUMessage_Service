package com.shu.message.model.entity;

import lombok.Data;

import java.util.Date;

@Data
public class UsersAndDate {
    private Integer usersAndDateId;

    private Integer usersId;

    private Date createTime;

    private Date deleteTime;
}