package com.shumsg.dao;

import com.shumsg.model.entity.News;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewsMapper {
//    List<UserNewsInfo> selectNewsList(@Param("offset")Integer offset, @Param("num") Integer num,
//                                      @Param("usersId")Integer usersId);
}



//@Data
//@EqualsAndHashCode(callSuper = true)
//public class UserNewsInfo extends News {
//    private Boolean liked;
//    private Boolean commented;
//    private Boolean shared;
//
//    private String username;
//    private String userImg;
//}