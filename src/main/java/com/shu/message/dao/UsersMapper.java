package com.shu.message.dao;

import com.shu.message.model.entity.Users;
import org.springframework.stereotype.Repository;



public interface UsersMapper {

    Users selectByUsersId(Integer usersId);

//    List<Users> selectAll();

    int insert(Users users);
}