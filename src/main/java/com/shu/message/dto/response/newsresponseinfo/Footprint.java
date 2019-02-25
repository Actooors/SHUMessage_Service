package com.shu.message.dto.response.newsresponseinfo;

import lombok.Data;

/**
 * @program: message
 * @description:
 * @author: 0GGmr0
 * @create: 2019-02-25 21:55
 */
@Data
public class Footprint {
    private Boolean like;
    private Boolean comment;
    private Boolean forward;

    public Footprint(Boolean like, Boolean comment, Boolean forward) {
        this.like = like;
        this.comment = comment;
        this.forward = forward;
    }
}
