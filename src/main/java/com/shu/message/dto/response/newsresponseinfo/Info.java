package com.shu.message.dto.response.newsresponseinfo;

import lombok.Data;

/**
 * @program: message
 * @description:
 * @author: 0GGmr0
 * @create: 2019-02-25 20:47
 */
@Data
public class Info {
    private Integer type;
    private Integer id;

    public Info(Integer ... arg) {
        type = arg[0];
        id = arg[1];
    }
}
