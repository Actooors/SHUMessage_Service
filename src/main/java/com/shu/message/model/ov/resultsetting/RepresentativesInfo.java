package com.shu.message.model.ov.resultsetting;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @program: message
 * @description:
 * @author: ggmr
 * @create: 2018-08-28 21:41
 */
public class RepresentativesInfo {
    private Map<String, String> author = new Hashtable<>();
    private String content;
    private List<String> imgs = new LinkedList<>();

    public Map<String, String> getAuthor() {
        return author;
    }

    public void setAuthor(String userId, String userName) {
        this.author.put("id", userId);
        this.author.put("name", userName);
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
}
