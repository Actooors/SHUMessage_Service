package com.shu.message.model.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Discuss {
    private Integer discussId;

    private Integer id;

    private Integer type;

    private Integer commentId;

    private Integer usersId;

    private String content;

    private Integer replyNum;

    private Integer replyLikeNum;

    private String imgUrl;

    private Boolean commented;

    private Date createTime;

    private Date deleteTime;
}