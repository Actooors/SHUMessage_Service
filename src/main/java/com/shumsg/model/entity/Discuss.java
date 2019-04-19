package com.shumsg.model.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Discuss {
    private String id;

    private String targetType;

    private String targetId;

    private String ancestorId;

    private String operatorId;

    private String content;

    private Integer discussNum;

    private Integer likedNum;

    private String img;

    private LocalDateTime createTime;

    private LocalDateTime deleteTime;

}