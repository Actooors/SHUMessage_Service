package com.shu.message.dto.response.newsresponseinfo;

import lombok.Data;

/**
 * @program: message
 * @description:
 * @author: 0GGmr0
 * @create: 2019-02-25 21:54
 */
@Data
public class ShareInfo {
    private Integer like;
    private Integer comment;
    private Integer share;

    public ShareInfo(Integer like, Integer comment, Integer share) {
        this.like = like;
        this.comment = comment;
        this.share = share;
    }
}
