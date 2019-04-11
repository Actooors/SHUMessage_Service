package com.shumsg.model.entity;

import lombok.Data;

import java.util.Date;

@Data
public class UserMessage {
    private String id;

    private String userId;

    private String noticeType;

    private String messageType;

    private String messageId;

    private Boolean haveRead;

    private Date createTime;

    private Date deleteTime;
}