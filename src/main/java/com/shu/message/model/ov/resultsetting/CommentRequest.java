package com.shu.message.model.ov.resultsetting;

import lombok.Data;

/**
 * @program: message
 * @description: 对新闻、动态进行评论前端请求信息格式
 * @author: xw
 * @create: 2018-08-29 18:37
 */

@Data
public class CommentRequest {
    public Integer type;
    public Integer id;
    public String content;
    public String img;
    public Integer replyId;
}
