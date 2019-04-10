package com.shumsg.dao;

import com.shumsg.model.entity.User;

public interface UserMapper {

    User selectUserByStudentCardId(String studentCardId);

}