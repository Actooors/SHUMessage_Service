package com.shumsg.model.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class News {
    private String id;

    private String userId;

    private String content;

    private String preContent;

    private String mediaType;

    private Object mediaImgs;

    private String mediaTitle;

    private String newsUrl;

    private Object newsLabels;

    private Integer discussNum;

    private Integer discussLikedNum;

    private Integer likedNum;

    private Integer rePostNum;

    private Integer viewsNum;

    private String contentFromScrapy;

    private String md5;

    private LocalDateTime createTime;

    private LocalDateTime discussUpdateTime;

    private LocalDateTime deleteTime;
}