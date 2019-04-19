package com.shumsg.model.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserInterestNews {
    private String id;

    private String content;

    private LocalDateTime createTime;

}