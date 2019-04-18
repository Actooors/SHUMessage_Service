package com.shumsg.model.front;

import lombok.Data;

import java.util.Date;

/**
 * @program: shumsg
 * @description: 爬虫端爬取新闻的接口
 * @author: 0GGmr0
 * @create: 2019-04-17 10:06
 */
@Data
public class SpiderNewsInfo {
    private String userId; // 发布者主键id
    private String mediaTitle; // 新闻的标题
    private String newsUrl; // 新闻的url
    private String newsLabel; // 新闻的标签(爬虫直接获取的标签)
    private String contentFromScrapy; // 爬虫获取的新闻的内容
    private String md5; // 验证爬虫唯一性的接口
    private Date createTime; // 新闻发布的时间
}
