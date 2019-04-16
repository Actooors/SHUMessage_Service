package com.shumsg.dao;

import com.shumsg.model.entity.User;
import com.shumsg.model.front.ModifyUserInfo;
import org.apache.ibatis.annotations.Param;


public interface UserMapper {

//    User selectUserByStudentCardId(String studentCardId);

//    User selectUserByUUId(String uuid);

//    User selectUserByNormalLoginId(String normalLoginId);

    User selectUserByUserInfo(@Param("info") String info,@Param("type") int type);

    int insert(User user);

    void updateUserByModifyUserInfo(ModifyUserInfo info);

    void updateEditableNicknameTimes(int editableNicknameTimes);

}