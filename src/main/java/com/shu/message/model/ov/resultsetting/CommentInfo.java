package com.shu.message.model.ov.resultsetting;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.*;

/**
 * @program: message
 * @description:
 * @author: ggmr
 * @create: 2018-08-28 20:52
 */
public class CommentInfo {
    private Map<String, Integer> info = new Hashtable<>();
    private String content;
    private List<String> imgs = new LinkedList<>();
    private UserInfo author;
    private Date publishTime;
    private int like;
    private ReplyInfo replies;

    public Map<String, Integer> getInfo() {
        return info;
    }

    public void setInfo(int type, int id) {
        this.info.put("type",type);
        this.info.put("id",id);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getPhotos() {
        return imgs;
    }

    public void setPhotos(String photos) {
        this.imgs.add(photos);
    }

    public UserInfo getAuthor() {
        return author;
    }

    public void setAuthor(UserInfo author) {
        this.author = author;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public ReplyInfo getReplies() {
        return replies;
    }

    public void setReplies(ReplyInfo replies) {
        this.replies = replies;
    }
}
