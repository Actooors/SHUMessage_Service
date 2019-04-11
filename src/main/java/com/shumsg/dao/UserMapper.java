package com.shumsg.dao;

import com.shumsg.model.entity.User;

import java.util.UUID;

public interface UserMapper {

    User selectUserByStudentCardId(String studentCardId);

    User selectUserByUUId(String uuid);

    int insert(User user);

}