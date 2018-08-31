package com.shu.message.model.entity;

import com.shu.message.model.entity.messagepackage.MessageAbstract;

import java.util.Date;

public class Topic extends MessageAbstract {
    private Integer topicId;
    private Integer newsId;
    private String imgUrl;

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }


    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }
}