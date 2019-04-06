package com.shu.message.model.ov.resultsetting;

import lombok.Data;

/**
 * @program: message
 * @description: 用户感兴趣的新闻的信息列表
 * @author: 0GGmr0
 * @create: 2019-03-26 22:22
 */
@Data
public class UserInterestedNewsInfo {
    private Integer newsId;
    private String title;
    private Integer likeNum;
}
