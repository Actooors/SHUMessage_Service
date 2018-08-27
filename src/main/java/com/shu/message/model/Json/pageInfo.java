package com.shu.message.model.Json;

import lombok.Data;

/**
 * @program: message
 * @description: 前端page需求
 * @author: xw
 * @create: 2018-08-28 01:04
 */

@Data
public class pageInfo {
    private Integer page;
    private Integer pageSize;
}
