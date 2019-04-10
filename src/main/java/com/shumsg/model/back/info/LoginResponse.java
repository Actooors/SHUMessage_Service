package com.shumsg.model.back.info;

import lombok.Data;

/**
 * @program: shumsg
 * @description:
 * @author: 0GGmr0
 * @create: 2019-04-10 22:27
 */
@Data
public class LoginResponse {

    private String token;
    private String username;
    private String userId;
    private String actualName;
    private String identity;
    private String studentId;

}
