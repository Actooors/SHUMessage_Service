package com.shumsg.model.entity;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class UserSubscribeLabel {
    private String id;

    private String userId;

    private String labelId;

    private Boolean needSendMsg;

    private LocalDateTime createTime;

    private LocalDateTime deleteTime;
}