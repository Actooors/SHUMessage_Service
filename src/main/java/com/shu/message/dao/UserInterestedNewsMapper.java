package com.shu.message.dao;

import com.shu.message.model.entity.UserInterestedNews;
import com.shu.message.model.entity.UserInterestedNewsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserInterestedNewsMapper {
    int countByExample(UserInterestedNewsExample example);

    int deleteByExample(UserInterestedNewsExample example);

    int deleteByPrimaryKey(Integer userInterestedNewsId);

    int insert(UserInterestedNews record);

    int insertSelective(UserInterestedNews record);

    List<UserInterestedNews> selectByExample(UserInterestedNewsExample example);

    UserInterestedNews selectByPrimaryKey(Integer userInterestedNewsId);

    int updateByExampleSelective(@Param("record") UserInterestedNews record, @Param("example") UserInterestedNewsExample example);

    int updateByExample(@Param("record") UserInterestedNews record, @Param("example") UserInterestedNewsExample example);

    int updateByPrimaryKeySelective(UserInterestedNews record);

    int updateByPrimaryKey(UserInterestedNews record);
}