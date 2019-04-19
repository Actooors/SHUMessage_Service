package com.shumsg.model.front;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @program: shumsg
 * @description: 爬虫端插入标签接口
 * @author: 0GGmr0
 * @create: 2019-04-17 15:42
 */
@Data
public class SpiderLabelInfo {
    @NotBlank(message = "biaoqi不能为空")
    private String labelName;
}
