package com.shu.message.dao;

import com.shu.message.model.entity.UserAndLabel;
import com.shu.message.model.entity.UserAndLabelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserAndLabelMapper {
    int countByExample(UserAndLabelExample example);

    int deleteByExample(UserAndLabelExample example);

    int deleteByPrimaryKey(Integer userAndLabelId);

    int insert(UserAndLabel record);

    int insertSelective(UserAndLabel record);

    List<UserAndLabel> selectByExample(UserAndLabelExample example);

    UserAndLabel selectByPrimaryKey(Integer userAndLabelId);

    int updateByExampleSelective(@Param("record") UserAndLabel record, @Param("example") UserAndLabelExample example);

    int updateByExample(@Param("record") UserAndLabel record, @Param("example") UserAndLabelExample example);

    int updateByPrimaryKeySelective(UserAndLabel record);

    int updateByPrimaryKey(UserAndLabel record);
}