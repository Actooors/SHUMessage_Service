package com.shu.message.dao;

import com.shu.message.model.entity.UserAndGroup;
import com.shu.message.model.entity.UserAndGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserAndGroupMapper {
    int countByExample(UserAndGroupExample example);

    int deleteByExample(UserAndGroupExample example);

    int deleteByPrimaryKey(Integer usersAndGroupsId);

    int insert(UserAndGroup record);

    int insertSelective(UserAndGroup record);

    List<UserAndGroup> selectByExample(UserAndGroupExample example);

    UserAndGroup selectByPrimaryKey(Integer usersAndGroupsId);

    int updateByExampleSelective(@Param("record") UserAndGroup record, @Param("example") UserAndGroupExample example);

    int updateByExample(@Param("record") UserAndGroup record, @Param("example") UserAndGroupExample example);

    int updateByPrimaryKeySelective(UserAndGroup record);

    int updateByPrimaryKey(UserAndGroup record);
}