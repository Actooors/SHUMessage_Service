package com.shu.message.dao;

import com.shu.message.model.entity.NewsAndLabel;
import com.shu.message.model.entity.NewsAndLabelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NewsAndLabelMapper {
    int countByExample(NewsAndLabelExample example);

    int deleteByExample(NewsAndLabelExample example);

    int deleteByPrimaryKey(Integer newsAndLabelId);

    int insert(NewsAndLabel record);

    int insertSelective(NewsAndLabel record);

    List<NewsAndLabel> selectByExample(NewsAndLabelExample example);

    NewsAndLabel selectByPrimaryKey(Integer newsAndLabelId);

    int updateByExampleSelective(@Param("record") NewsAndLabel record, @Param("example") NewsAndLabelExample example);

    int updateByExample(@Param("record") NewsAndLabel record, @Param("example") NewsAndLabelExample example);

    int updateByPrimaryKeySelective(NewsAndLabel record);

    int updateByPrimaryKey(NewsAndLabel record);
}