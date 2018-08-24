package com.shu.message.model.entity;

import java.util.Date;

public class News {
    private String md5Id;

    private String title;

    private String author;

    private Date createDate;

    private String webName;

    private String url;

    private String apartment;

    private String tag;

    private String content;

    private String imageUrlList;

    public String getMd5Id() {
        return md5Id;
    }

    public void setMd5Id(String md5Id) {
        this.md5Id = md5Id == null ? null : md5Id.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
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

    public String getWebName() {
        return webName;
    }

    public void setWebName(String webName) {
        this.webName = webName == null ? null : webName.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment == null ? null : apartment.trim();
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
}