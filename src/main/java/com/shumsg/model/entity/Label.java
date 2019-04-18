package com.shumsg.model.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Label {
    private String id;

    private String name;

    private Date createTime;

    private Date deleteTime;

}