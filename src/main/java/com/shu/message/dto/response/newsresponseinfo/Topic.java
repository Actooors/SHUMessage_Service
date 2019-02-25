package com.shu.message.dto.response.newsresponseinfo;

import lombok.Data;

/**
 * @program: message
 * @description:
 * @author: 0GGmr0
 * @create: 2019-02-25 21:53
 */
@Data
public class Topic {
    private Integer id;
    private String name;

    public Topic(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
