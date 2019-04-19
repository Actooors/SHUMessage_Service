package com.shumsg.model.front;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @description: 登录请求信息
 * @author: 0GGmr0
 * @create: 2019-04-10 21:52
 */
@Data
public class LoginInfo {
    @NotBlank(message = "登录账号不能为空")
    private String userId;
    @NotBlank(message = "密码不能为空")
    private String password;
    @NotBlank(message = "登录种类不能为空")
    private String loginType;
}
