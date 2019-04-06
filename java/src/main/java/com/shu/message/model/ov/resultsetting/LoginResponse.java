package com.shu.message.model.ov.resultsetting;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: message
 * @description:
 * @author: ggmr
 * @create: 2018-08-24 10:52
 */
@Data
public class LoginResponse {
    @JsonProperty("token")
    private String token;
    @JsonProperty("username")
    private String userName;
    @JsonProperty("uid")
    private String userId;
}
