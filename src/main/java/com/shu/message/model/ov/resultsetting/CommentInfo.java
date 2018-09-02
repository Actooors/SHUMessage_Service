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
    private Map<String, Integer> shareInfo = new Hashtable<>();
    private Map<String, Boolean> footprint = new Hashtable<>();


    private ReplyInfo replies;


    public Map<String, Integer> getShareInfo() {
        return shareInfo;
    }

    public void setShareInfo(int shareNum) {
        this.shareInfo.put("like", shareNum);
    }

    public Map<String, Boolean> getFootprint() {
        return footprint;
    }

    public void setFootprint(Boolean isLiked) {
        this.footprint.put("like", isLiked);
    }

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

    public List<String> getImgs() {
        return imgs;
    }

    public void setImgs(String photos) {
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

    public ReplyInfo getReplies() {
        return replies;
    }

    public void setReplies(ReplyInfo replies) {
        this.replies = replies;
    }
}
