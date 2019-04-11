package com.shumsg.model.back.info;

import lombok.Data;

import java.util.UUID;

/**
 * @program: shumsg
 * @description:
 * @author: 0GGmr0
 * @create: 2019-04-10 22:27
 */
@Data
public class LoginResponse {

    private String token;
    // 用户UUID
    private String userId;
    // 真实姓名
    private String actualName;
    // 用户身份
    private String identity;
    // 工号
    private String studentCardId;
    // 学院

}
