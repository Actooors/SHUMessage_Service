package com.shu.message.dao;

import com.shu.message.model.entity.Iframe;
import com.shu.message.model.entity.IframeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IframeMapper {
    int countByExample(IframeExample example);

    int deleteByExample(IframeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Iframe record);

    int insertSelective(Iframe record);

    List<Iframe> selectByExample(IframeExample example);

    Iframe selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Iframe record, @Param("example") IframeExample example);

    int updateByExample(@Param("record") Iframe record, @Param("example") IframeExample example);

    int updateByPrimaryKeySelective(Iframe record);

    int updateByPrimaryKey(Iframe record);
}