package com.shu.message.service;

import com.shu.message.dao.*;
import com.shu.message.model.entity.Group;
import com.shu.message.model.entity.UserAndGroup;
import com.shu.message.model.entity.UserAndGroupExample;
import com.shu.message.model.ov.Result;
import com.shu.message.model.ov.resultsetting.GroupInfo;
import com.shu.message.tools.ResultTool;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: message
 * @description: 圈子service
 * @author: 0GGmr0
 * @create: 2019-03-28 01:07
 */
@Service
public class GroupService {
    @Resource
    private UserMapper userMapper;

    @Resource
    private LikeMapper likeMapper;

    @Resource
    private NewsMapper newsMapper;

    @Resource
    private TopicMapper topicMapper;

    @Resource
    private GroupMapper groupMapper;

    @Resource
    private UserAndGroupMapper userAndGroupMapper;

    /**
     * @Description: 查看圈子信息
     * @Param: [userId, groupId]
     * @Return: com.shu.message.model.ov.Result
     * @Author: 0GGmr0
     * @Date: 2019-03-28
     */
    public Result getGroupMessage(String userId, int groupId) {
        Group group = groupMapper.selectByPrimaryKey(groupId);
        GroupInfo res = new GroupInfo();
        res.setAbout(group.getDescription());
        UserAndGroupExample example = new UserAndGroupExample();
        example.createCriteria().andUserIdEqualTo(userId).andOtherGroupIdEqualTo(groupId);
        if(userAndGroupMapper.selectByExample(example).isEmpty()) {
            res.setAdded(false);
        } else {
            res.setAdded(true);
        }
        res.setName(group.getGroupsName());
        res.setMessageNum(group.getMessageNum());
        res.setMemberNum(group.getPeopleNum());
        res.setGroupId(group.getGroupsId());
        return ResultTool.success(res);
    }

    public Result joinGroup(String userId, int groupId) {
        Group group = groupMapper.selectByPrimaryKey(groupId);
        group.setPeopleNum(group.getPeopleNum() + 1);
        groupMapper.updateByPrimaryKeySelective(group);
        UserAndGroup userAndGroup = new UserAndGroup();
        userAndGroup.setOtherGroupId(groupId);
        userAndGroup.setUserId(userId);
        userAndGroupMapper.insert(userAndGroup);
        return ResultTool.success("加入圈子成功");
    }


}
