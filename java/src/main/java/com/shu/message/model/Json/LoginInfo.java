package com.shu.message.model.Json;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: message
 * @description:
 * @author: ggmr
 * @create: 2018-08-24 10:44
 */
@Data
public class LoginInfo {
    @JsonProperty("uid")
    private String userId;

    private String password;
}
