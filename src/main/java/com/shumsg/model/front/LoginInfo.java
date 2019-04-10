package com.shumsg.model.front;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: shumsg
 * @description: 登录请求信息
 * @author: 0GGmr0
 * @create: 2019-04-10 21:52
 */
@Data
public class LoginInfo {
    private String userId;
    private String password;
}
