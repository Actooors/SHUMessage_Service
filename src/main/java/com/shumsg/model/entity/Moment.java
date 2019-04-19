package com.shumsg.model.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Moment {
    private String id;

    private String userId;

    private String content;

    private String preContent;

    private Boolean momentType;

    private String rePostTargetId;

    private String rePostType;

    private Object mediaImgs;

    private Object location;

    private String locationPlace;

    private String groupId;

    private Integer discussNum;

    private Integer discussLikedNum;

    private Integer likedNum;

    private Integer rePostNum;

    private Integer viewsNum;

    private LocalDateTime createTime;

    private LocalDateTime discussUpdateTime;

    private LocalDateTime deleteTime;
}