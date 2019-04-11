package com.shumsg.model.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Group {
    private String id;

    private String name;

    private String description;

    private String avatar;

    private String background;

    private String creatorId;

    private Integer memberNum;

    private Date createTime;

    private Date deleteTime;

}