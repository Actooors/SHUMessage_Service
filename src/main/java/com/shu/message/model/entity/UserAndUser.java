package com.shu.message.model.entity;

public class UserAndUser {
    private Integer userAndUserId;

    private String userId;

    private String targetUserId;

    public Integer getUserAndUserId() {
        return userAndUserId;
    }

    public void setUserAndUserId(Integer userAndUserId) {
        this.userAndUserId = userAndUserId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getTargetUserId() {
        return targetUserId;
    }

    public void setTargetUserId(String targetUserId) {
        this.targetUserId = targetUserId == null ? null : targetUserId.trim();
    }
}