package com.shu.message.model.ov.resultsetting;

import lombok.Data;

/**
 * @program: message
 * @description: 一个标签有多少数量的新闻
 * @author: 0GGmr0
 * @create: 2019-03-27 11:10
 */

@Data
public class LabelNewsNum {
    private Integer labelId;
    private String labelName;
    private Integer num;
}
