package com.shu.message.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class News {
    private Integer newsId;

    private String md5Id;

    private String author;

    @JsonFormat(locale="zh", timezone = "GMT+8", pattern = "yyyy-MM-ddTHH:mm:ss")
    private Date createDate;

    private String webNameId;

    private Integer likeNum;

    public Integer getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }

    private String webName;

    private String apartment;

    private Integer tagId;

    private String tag;

    private String content;

    private String imageUrlList;

    private Integer commentNum;

    private Integer sharesNum;

    private String url;

    private String title;

    private Integer type;

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public String getMd5Id() {
        return md5Id;
    }

    public void setMd5Id(String md5Id) {
        this.md5Id = md5Id == null ? null : md5Id.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getWebNameId() {
        return webNameId;
    }

    public void setWebNameId(String webNameId) {
        this.webNameId = webNameId == null ? null : webNameId.trim();
    }

    public String getWebName() {
        return webName;
    }

    public void setWebName(String webName) {
        this.webName = webName == null ? null : webName.trim();
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment == null ? null : apartment.trim();
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getImageUrlList() {
        return imageUrlList;
    }

    public void setImageUrlList(String imageUrlList) {
        this.imageUrlList = imageUrlList == null ? null : imageUrlList.trim();
    }

    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }

    public Integer getSharesNum() {
        return sharesNum;
    }

    public void setSharesNum(Integer sharesNum) {
        this.sharesNum = sharesNum;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}