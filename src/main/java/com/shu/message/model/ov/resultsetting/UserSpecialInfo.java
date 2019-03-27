package com.shu.message.model.ov.resultsetting;

import com.shu.message.model.entity.UserAndLabel;
import lombok.Data;

import java.util.List;

/**
 * @program: message
 * @description: 用户详细信息
 * @author: 0GGmr0
 * @create: 2019-03-28 00:20
 */
@Data
public class UserSpecialInfo {
    private String name;
    private String personalLabel; //个性标签
//    private List<String> personalLabelList;
    private String avator;
    private int followMe;     //关注我的人
    private int followOthers; // 关注其他人的数目
    private int joinGroupNum;  //加入圈子的数目
    private int createGroupNum; //关注圈子的数目
//    private String pictureBack; //图片背景墙
}
