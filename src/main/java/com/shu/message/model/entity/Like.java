package com.shu.message.model.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Like {
    private Integer likeId;

    private Integer id;

    private Integer type;

    private Integer usersId;

    private Boolean liked;

    private Date createTime;

    private Date deleteTime;


}