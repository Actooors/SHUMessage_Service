package com.shumsg.model.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Like {
    private String id;

    private String targetType;

    private String targetId;

    private String operatorId;

    private Boolean liked;

    private LocalDateTime createTime;

    private LocalDateTime deleteTime;

}