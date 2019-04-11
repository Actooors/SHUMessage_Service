package com.shumsg.model.entity;

import lombok.Data;

import java.util.Date;

@Data
public class UserInterestNews {
    private String id;

    private String content;

    private Date createTime;

}