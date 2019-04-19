package com.shumsg.model.front;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @program: shumsg
 * @description: 用户修改个人信息的数据格式
 * @author: 0GGmr0
 * @create: 2019-04-12 17:57
 */
@Data
public class ModifyUserInfo {

    private String nickname;
    private String normalLoginId;
    private String password;
    private String phone;
    private String mail;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate birthday;
    private String gender;
    private String about;
    private String job;
    private String avatar;
    private String background;
    private String birthplace;
    private String location;
    private String school;

    // 下面的部分为后端自己操作dao层是会用到的内容
    private String passwordSalt;
    private Integer editableNicknameTimes;
    private String id;

}
