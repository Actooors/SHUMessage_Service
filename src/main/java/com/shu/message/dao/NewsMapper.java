package com.shu.message.dao;

import com.shu.message.model.mapresult.UserNewsInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface NewsMapper {

    List<UserNewsInfo> selectNewsList(@Param("startRow")Integer startRow,@Param("endRow") Integer endRow);

//    UserNewsInfo selectUserNewsInfo(Integer newsId);

}