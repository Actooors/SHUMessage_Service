package com.shumsg.model.entity;

import lombok.Data;

import java.util.Date;

@Data
public class UserSubscribeLabel {
    private String id;

    private String userId;

    private String labelId;

    private Boolean needSendMsg;

    private Date createTime;

    private Date deleteTime;
}