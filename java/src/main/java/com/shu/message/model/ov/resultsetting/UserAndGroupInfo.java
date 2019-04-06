package com.shu.message.model.ov.resultsetting;

import lombok.Data;

import java.util.List;

/**
 * @program: message
 * @description: 用户加入的圈子列表信息
 * @author: 0GGmr0
 * @create: 2019-03-28 12:59
 */
@Data
public class UserAndGroupInfo {

    private Integer groupId;
    private String name;
    private String about;
    private Integer memberNum;
    private String[] titleList;

}
