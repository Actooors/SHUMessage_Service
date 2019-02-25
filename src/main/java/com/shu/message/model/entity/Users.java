package com.shu.message.model.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Users {
    private Integer usersId;

    private Integer type;

    private String username;

    private String studentId;

    private String password;

    private String realName;

    private String department;

    private String phone;

    private String mail;

    private String label;

    private String birthday;

    private String sex;

    private String location;

    private String school;

    private String job;

    private Integer identity;

    private Boolean isAbleLogin;

    private String userImg;

    private String userBigImg;

    private String backImg;

    private Integer lastingNum;

    private Date lastLoginTime;

    private Integer socialGroupNum;

    private Integer followNum;

    private Integer beConcernedNum;

    private Integer mySocialGroupNum;

    private Date createTime;

    private Date deleteTime;
}