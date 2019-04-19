package com.shumsg.model.entity;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class UserMessage {
    private String id;

    private String userId;

    private String noticeType;

    private String messageType;

    private String messageId;

    private Boolean haveRead;

    private LocalDateTime createTime;

    private LocalDateTime deleteTime;
}