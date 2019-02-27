package com.shu.message.model.mapresult;

import com.shu.message.model.entity.News;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @program: message
 * @description: 用户对一个新闻是否点赞，评论，分享
 * @author: 0GGmr0
 * @create: 2019-02-25 08:14
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserNewsInfo extends News {
    private Boolean liked;
    private Boolean commented;
    private Boolean shared;

    private String username;
    private String userImg;
}
