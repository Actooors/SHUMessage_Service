package com.shumsg.model.front;

import lombok.Data;

/**
 * @program: shumsg
 * @description: 爬虫端调用接口传送的数据格式
 * @author: 0GGmr0
 * @create: 2019-04-16 19:08
 */
@Data
public class SpiderNews {
    private String userId; // 新闻发布者id
    private String content; // 爬取的新闻内容
    private String title; // 新闻的标题
    private String url; // 新闻的url
    private String label; // 新闻的标签

}
