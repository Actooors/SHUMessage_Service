package com.shu.message.dao;

import com.shu.message.model.entity.Label;
import com.shu.message.model.entity.LabelExample;
import java.util.List;

import com.shu.message.model.ov.resultsetting.LabelNewsNum;
import org.apache.ibatis.annotations.Param;

public interface LabelMapper {
    int countByExample(LabelExample example);

    int deleteByExample(LabelExample example);

    int deleteByPrimaryKey(String labelId);

    int insert(Label record);

    int insertSelective(Label record);

    List<Label> selectByExample(LabelExample example);

    Label selectByPrimaryKey(String labelId);

    int updateByExampleSelective(@Param("record") Label record, @Param("example") LabelExample example);

    int updateByExample(@Param("record") Label record, @Param("example") LabelExample example);

    int updateByPrimaryKeySelective(Label record);

    int updateByPrimaryKey(Label record);

    List<Label> getLabels(String userId);

//    List<LabelNewsNum> getLabelNum(String userId);
    List<Integer> getLabelNum(String userId);

}