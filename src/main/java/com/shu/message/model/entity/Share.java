package com.shu.message.model.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Share {
    private Integer shareId;

    private Integer id;

    private Integer type;

    private Integer usersId;

    private Date createTime;

    private Date deleteTime;

    private Boolean shared;

}