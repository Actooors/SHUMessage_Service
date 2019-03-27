package com.shu.message.dao;

import com.shu.message.model.entity.News;
import com.shu.message.model.entity.NewsExample;
import java.util.List;

import com.shu.message.model.ov.resultsetting.UserInterestedNewsInfo;
import org.apache.ibatis.annotations.Param;

public interface NewsMapper {
    int countByExample(NewsExample example);

    int deleteByExample(NewsExample example);

    int deleteByPrimaryKey(Integer newsId);

    int insert(News record);

    int insertSelective(News record);

    List<News> selectByExample(NewsExample example);

    News selectByPrimaryKey(Integer newsId);

    int updateByExampleSelective(@Param("record") News record, @Param("example") NewsExample example);

    int updateByExample(@Param("record") News record, @Param("example") NewsExample example);

    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKey(News record);

//    int selectMessageListByUserId(String userId);

    List<News> selectNewsByLabelId(int labelId);
}