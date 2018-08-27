package com.shu.message.model.ov.ResultSetting;

import io.swagger.models.auth.In;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @program: message
 * @description: 获取新闻列表response
 * @author: xw
 * @create: 2018-08-28 01:18
 */
public class NewsResponse {

    private Map info = new HashMap();
    private Map topic = new HashMap();
    private String content;
    private Map author = new HashMap();
    private String extraInfo;
    private Map shareInfo = new HashMap();
    private String url;

    public Map getInfo() {
        return info;
    }

    public void setInfo(String id) {
        this.info.put("type",0);
        this.info.put("id",id);
    }

    public Map getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic.put("id",topic);
        this.topic.put("name",topic);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Map getAuthor() {
        return author;
    }

    public void setAuthor(String webname, String name) {
        this.author.put("id",webname);
        this.author.put("avatar","https://avatars2.githubusercontent.com/u/30586220?s=460&v=4");
        this.author.put("name", name);
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
        this.shareInfo.put("commit",comment);
        this.shareInfo.put("share",share);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
