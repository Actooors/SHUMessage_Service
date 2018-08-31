package com.shu.message.model.entity;

public class Topic {
    private Integer topicId;

    private String content;

    private Integer newsId;

    private Integer type;

    private Integer commentNum;

    private Integer likeNum;

    private Integer sharesNum;

    private String imgUrl;

    private String usreId;

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }

    public Integer getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }

    public Integer getSharesNum() {
        return sharesNum;
    }

    public void setSharesNum(Integer sharesNum) {
        this.sharesNum = sharesNum;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    public String getUsreId() {
        return usreId;
    }

    public void setUsreId(String usreId) {
        this.usreId = usreId == null ? null : usreId.trim();
    }
}