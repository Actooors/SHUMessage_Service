package com.shu.message.dao;

import com.shu.message.model.entity.UserAndUser;
import com.shu.message.model.entity.UserAndUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserAndUserMapper {
    int countByExample(UserAndUserExample example);

    int deleteByExample(UserAndUserExample example);

    int deleteByPrimaryKey(Integer userAndUserId);

    int insert(UserAndUser record);

    int insertSelective(UserAndUser record);

    List<UserAndUser> selectByExample(UserAndUserExample example);

    UserAndUser selectByPrimaryKey(Integer userAndUserId);

    int updateByExampleSelective(@Param("record") UserAndUser record, @Param("example") UserAndUserExample example);

    int updateByExample(@Param("record") UserAndUser record, @Param("example") UserAndUserExample example);

    int updateByPrimaryKeySelective(UserAndUser record);

    int updateByPrimaryKey(UserAndUser record);
}