package com.shu.message.model.entity;

import lombok.Data;

import java.util.Date;

@Data
public class NewsAndLabels {
    private Integer newsAndLabels;

    private Integer newsId;

    private Integer labelsId;

    private String labelsName;

    private Date createTime;

    private Date deleteTime;
}