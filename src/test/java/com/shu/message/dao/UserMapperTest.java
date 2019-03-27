package com.shu.message.dao;

import com.shu.message.model.entity.User;
import org.junit.Test;

import javax.annotation.Resource;

public class UserMapperTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void selectByPrimaryKey() {

        User existedUser = userMapper.selectByPrimaryKey("16122131");
        if (existedUser == null){
            System.out.print("null");
        }else{
            System.out.print("xxx");
        }
    }
}