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

    public void setInfo(int id) {
        this.info.put("type",0);
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

    public void setShareInfo(Integer like, Integer comment, Integer share) {
        this.shareInfo.put("like",like);
        this.shareInfo.put("comment",comment);
        this.shareInfo.put("share",share);
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


//    media:{
//        type:"url",
//                title:"",//新闻标题，若无标题请置null
//                url:""//爬取的新闻请将原新闻url写在这里
//    }
////图片
//    media:{
//        type:"img",
//                imgs:["",""]//最多3张
//    }
}
