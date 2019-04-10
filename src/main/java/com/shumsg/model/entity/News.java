package com.shumsg.model.entity;

import java.util.Date;

public class News {
    private Object id;

    private String userId;

    private String content;

    private String preContent;

    private String mediaType;

    private Object mediaImgs;

    private String mediaTitle;

    private String newsUrl;

    private Object newsLabels;

    private Integer discussNum;

    private Integer discussLikedNum;

    private Integer likedNum;

    private Integer rePostNum;

    private Integer viewsNum;

    private String contentFromScrapy;

    private String md5;

    private Date createTime;

    private Date discussUpdateTime;

    private Date deleteTime;

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
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

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType == null ? null : mediaType.trim();
    }

    public Object getMediaImgs() {
        return mediaImgs;
    }

    public void setMediaImgs(Object mediaImgs) {
        this.mediaImgs = mediaImgs;
    }

    public String getMediaTitle() {
        return mediaTitle;
    }

    public void setMediaTitle(String mediaTitle) {
        this.mediaTitle = mediaTitle == null ? null : mediaTitle.trim();
    }

    public String getNewsUrl() {
        return newsUrl;
    }

    public void setNewsUrl(String newsUrl) {
        this.newsUrl = newsUrl == null ? null : newsUrl.trim();
    }

    public Object getNewsLabels() {
        return newsLabels;
    }

    public void setNewsLabels(Object newsLabels) {
        this.newsLabels = newsLabels;
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

    public String getContentFromScrapy() {
        return contentFromScrapy;
    }

    public void setContentFromScrapy(String contentFromScrapy) {
        this.contentFromScrapy = contentFromScrapy == null ? null : contentFromScrapy.trim();
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5 == null ? null : md5.trim();
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