package com.shumsg.model.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Like {
    private String id;

    private String targetType;

    private String targetId;

    private String operatorId;

    private Boolean liked;

    private Date createTime;

    private Date deleteTime;

}