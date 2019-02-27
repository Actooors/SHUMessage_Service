package com.shu.message.dao;

import com.shu.message.model.mapresult.UserNewsInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface NewsMapper {

    List<UserNewsInfo> selectNewsList(@Param("offset")Integer offset, @Param("num") Integer num,
                                      @Param("usersId")Integer usersId);

//    UserNewsInfo selectUserNewsInfo(Integer newsId);

}