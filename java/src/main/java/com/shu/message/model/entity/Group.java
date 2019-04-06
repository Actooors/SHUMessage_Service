package com.shu.message.model.entity;

import java.util.Date;

public class Group {
    private Integer groupsId;

    private String groupsName;

    private String description;

    private Integer groupsLabel;

    private Integer usersId;

    private Integer peopleNum;

    private Integer messageNum;

    private Date createTime;

    public Integer getGroupsId() {
        return groupsId;
    }

    public void setGroupsId(Integer groupsId) {
        this.groupsId = groupsId;
    }

    public String getGroupsName() {
        return groupsName;
    }

    public void setGroupsName(String groupsName) {
        this.groupsName = groupsName == null ? null : groupsName.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getGroupsLabel() {
        return groupsLabel;
    }

    public void setGroupsLabel(Integer groupsLabel) {
        this.groupsLabel = groupsLabel;
    }

    public Integer getUsersId() {
        return usersId;
    }

    public void setUsersId(Integer usersId) {
        this.usersId = usersId;
    }

    public Integer getPeopleNum() {
        return peopleNum;
    }

    public void setPeopleNum(Integer peopleNum) {
        this.peopleNum = peopleNum;
    }

    public Integer getMessageNum() {
        return messageNum;
    }

    public void setMessageNum(Integer messageNum) {
        this.messageNum = messageNum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}