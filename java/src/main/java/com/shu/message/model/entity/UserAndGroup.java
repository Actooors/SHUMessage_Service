package com.shu.message.model.entity;

import java.util.Date;

public class UserAndGroup {
    private Integer usersAndGroupsId;

    private String userId;

    private Integer otherGroupId;

    private Date createTime;

    public Integer getUsersAndGroupsId() {
        return usersAndGroupsId;
    }

    public void setUsersAndGroupsId(Integer usersAndGroupsId) {
        this.usersAndGroupsId = usersAndGroupsId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Integer getOtherGroupId() {
        return otherGroupId;
    }

    public void setOtherGroupId(Integer otherGroupId) {
        this.otherGroupId = otherGroupId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}