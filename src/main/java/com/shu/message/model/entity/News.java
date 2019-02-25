package com.shu.message.model.entity;

import lombok.Data;

import java.util.Date;

@Data
public class News {
    private Integer newsId;

    private String newsName;

    private Integer usersId;

    private String newsUrl;

    private String newsContent;

    private String newsDescription;

    private String imgUrl;

    private Integer type;

    private Integer commentNum;

    private Integer likeNum;

    private Integer shareNum;

    private Date createTime;

    private Date deleteTime;
}