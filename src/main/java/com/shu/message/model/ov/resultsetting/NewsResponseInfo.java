package com.shu.message.model.ov.resultsetting;


import java.util.*;

/**
 * @program: message
 * @description: 获取新闻列表response
 * @author: xw
 * @create: 2018-08-28 01:18
 */
public class NewsResponseInfo {

    private Map<String, Integer> info = new Hashtable<>();
    private Map<String, Object> topic = new Hashtable<>();
    private String content;
    private UserInfo author;
    private String extraInfo;
    private Date publishTime;
    private Map<String, Integer> shareInfo = new Hashtable<>();
    private Map<String, Object> media = new Hashtable<>();
    private Map<String, Boolean> footprint = new Hashtable<>();

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }
    public UserInfo getAuthor() {
        return author;
    }

    public void setAuthor(UserInfo author) {
        this.author = author;
    }

    public Map getInfo() {
        return info;
    }

    public void setInfo(int type, int id) {
        this.info.put("type", type);
        this.info.put("id",id);
    }

    public Map getTopic() {
        return topic;
    }

    public void setTopic(Integer topicId, String topic) {
        this.topic.put("id",topicId);
        this.topic.put("name",topic);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }



    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }

    public Map getShareInfo() {
        return shareInfo;
    }

    public void setShareInfo(Integer ... num) {
        this.shareInfo.put("like", num[0]);
        this.shareInfo.put("comment", num[1]);
        this.shareInfo.put("share", num[2]);
    }

    public Map<String, Object> getMedia() {
        return media;
    }

    public void setMedia(int type, String ... value) {
        if (type == 1) {
            this.media.put("type", "url");
            this.media.put("title", value[0]);
            this.media.put("value", value[1]);
        } else {
            this.media.put("type","img");
            String[] imgList = value[0].split("\\|");
            List<String> resList= Arrays.asList(imgList);
            this.media.put("imgs", resList);
        }
    }

    public Map<String, Boolean> getFootprint() {
        return footprint;
    }

    public void setFootprint(Boolean ... judge) {
        this.footprint.put("like", judge[0]);
        this.footprint.put("comment", judge[1]);
        this.footprint.put("forward", judge[2]);
    }
}
