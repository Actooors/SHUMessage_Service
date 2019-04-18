package com.shumsg.dao;

import com.shumsg.model.entity.Label;
import org.apache.ibatis.annotations.Param;

public interface LabelMapper {

    int insert(Label label);

    Label selectLabelByLabelInfo(@Param("info") String info, @Param("type") int type);

}