package com.shu.message.model.ov.resultsetting;

import lombok.Data;

/**
 * @program: message
 * @description: 圈子信息
 * @author: 0GGmr0
 * @create: 2019-03-28 01:13
 */
@Data
public class GroupInfo {
    private Integer groupId;
    private String name;
    private String about;
    private int memberNum;
    private int messageNum;
    private Boolean added;
}
