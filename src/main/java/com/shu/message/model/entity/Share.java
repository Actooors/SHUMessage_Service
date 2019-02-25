package com.shu.message.model.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Share {
    private Integer shareId;

    private Integer id;

    private Integer type;

    private Integer userId;

    private Boolean shared;

    private Date createTime;

    private Date deleteTime;
}