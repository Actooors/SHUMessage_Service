package com.shu.message.model.entity;

import java.util.Date;

public class UserInterestedNews {
    private String userInterestedNewsId;

    private String content;

    private Date createDate;

    public String getUserInterestedNewsId() {
        return userInterestedNewsId;
    }

    public void setUserInterestedNewsId(String userInterestedNewsId) {
        this.userInterestedNewsId = userInterestedNewsId == null ? null : userInterestedNewsId.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}