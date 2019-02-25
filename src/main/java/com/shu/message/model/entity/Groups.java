package com.shu.message.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
public class Groups {
    private Integer groupsId;

    private String groupsName;

    private String description;

    private Integer groupsLabel;

    private Integer usersId;

    private Integer peopleNum;

    private Date createTime;

    private Date deleteTime;
}