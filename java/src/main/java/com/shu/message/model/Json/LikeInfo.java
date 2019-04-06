package com.shu.message.model.Json;

import lombok.Data;

/**
 * @program: message
 * @description:
 * @author: ggmr
 * @create: 2018-08-31 14:47
 */
@Data
public class LikeInfo {
    private int type;
    private int id;
    private Boolean like;
}
