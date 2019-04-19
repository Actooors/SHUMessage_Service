package com.shumsg.model.front;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @program: shumsg
 * @description: 爬虫端插入官方用户的信息
 * @author: 0GGmr0
 * @create: 2019-04-16 23:14
 */
@Data
public class SpiderUserInfo {
    @NotBlank(message = "昵称不能为空")
    private String nickname;
    @NotBlank(message = "头像不能为空")
    private String avatar;
}
