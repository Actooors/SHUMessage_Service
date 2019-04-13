package com.shumsg.dao;

import com.shumsg.model.entity.User;
import com.shumsg.model.front.ModifyUserInfo;


public interface UserMapper {

    User selectUserByStudentCardId(String studentCardId);

    User selectUserByUUId(String uuid);

    User selectUserByNormalLoginId(String normalLoginId);

    int insert(User user);

    void updateUserByModifyUserInfo(ModifyUserInfo info);

    void updateEditableNicknameTimes(int editableNicknameTimes);

}