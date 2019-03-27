package com.shu.message.model.entity;

import java.util.Date;

public class UserInterestedNews {
    private Integer userInterestedNewsId;

    private String content;

    private String userId;

    private Date createDate;

    public Integer getUserInterestedNewsId() {
        return userInterestedNewsId;
    }

    public void setUserInterestedNewsId(Integer userInterestedNewsId) {
        this.userInterestedNewsId = userInterestedNewsId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}