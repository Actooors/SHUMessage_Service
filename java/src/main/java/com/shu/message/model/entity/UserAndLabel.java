package com.shu.message.model.entity;

public class UserAndLabel {
    private Integer userAndLabelId;

    private String userId;

    private Integer labelId;

    public Integer getUserAndLabelId() {
        return userAndLabelId;
    }

    public void setUserAndLabelId(Integer userAndLabelId) {
        this.userAndLabelId = userAndLabelId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Integer getLabelId() {
        return labelId;
    }

    public void setLabelId(Integer labelId) {
        this.labelId = labelId;
    }
}