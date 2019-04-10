package com.shumsg.model.entity;

import java.util.Date;

public class Moment {
    private Object id;

    private Object userId;

    private String content;

    private String preContent;

    private Boolean momentType;

    private Object rePostTargetId;

    private String rePostType;

    private Object mediaImgs;

    private Object location;

    private String locationPlace;

    private Object groupId;

    private Integer discussNum;

    private Integer discussLikedNum;

    private Integer likedNum;

    private Integer rePostNum;

    private Integer viewsNum;

    private Date createTime;

    private Date discussUpdateTime;

    private Date deleteTime;

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public Object getUserId() {
        return userId;
    }

    public void setUserId(Object userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getPreContent() {
        return preContent;
    }

    public void setPreContent(String preContent) {
        this.preContent = preContent == null ? null : preContent.trim();
    }

    public Boolean getMomentType() {
        return momentType;
    }

    public void setMomentType(Boolean momentType) {
        this.momentType = momentType;
    }

    public Object getRePostTargetId() {
        return rePostTargetId;
    }

    public void setRePostTargetId(Object rePostTargetId) {
        this.rePostTargetId = rePostTargetId;
    }

    public String getRePostType() {
        return rePostType;
    }

    public void setRePostType(String rePostType) {
        this.rePostType = rePostType == null ? null : rePostType.trim();
    }

    public Object getMediaImgs() {
        return mediaImgs;
    }

    public void setMediaImgs(Object mediaImgs) {
        this.mediaImgs = mediaImgs;
    }

    public Object getLocation() {
        return location;
    }

    public void setLocation(Object location) {
        this.location = location;
    }

    public String getLocationPlace() {
        return locationPlace;
    }

    public void setLocationPlace(String locationPlace) {
        this.locationPlace = locationPlace == null ? null : locationPlace.trim();
    }

    public Object getGroupId() {
        return groupId;
    }

    public void setGroupId(Object groupId) {
        this.groupId = groupId;
    }

    public Integer getDiscussNum() {
        return discussNum;
    }

    public void setDiscussNum(Integer discussNum) {
        this.discussNum = discussNum;
    }

    public Integer getDiscussLikedNum() {
        return discussLikedNum;
    }

    public void setDiscussLikedNum(Integer discussLikedNum) {
        this.discussLikedNum = discussLikedNum;
    }

    public Integer getLikedNum() {
        return likedNum;
    }

    public void setLikedNum(Integer likedNum) {
        this.likedNum = likedNum;
    }

    public Integer getRePostNum() {
        return rePostNum;
    }

    public void setRePostNum(Integer rePostNum) {
        this.rePostNum = rePostNum;
    }

    public Integer getViewsNum() {
        return viewsNum;
    }

    public void setViewsNum(Integer viewsNum) {
        this.viewsNum = viewsNum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getDiscussUpdateTime() {
        return discussUpdateTime;
    }

    public void setDiscussUpdateTime(Date discussUpdateTime) {
        this.discussUpdateTime = discussUpdateTime;
    }

    public Date getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }
}