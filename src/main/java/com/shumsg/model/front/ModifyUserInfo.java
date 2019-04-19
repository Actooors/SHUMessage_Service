package com.shumsg.model.front;

import com.shumsg.model.entity.User;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

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
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date birthday;
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
