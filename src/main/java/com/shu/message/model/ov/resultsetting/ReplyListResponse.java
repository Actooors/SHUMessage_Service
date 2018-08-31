package com.shu.message.model.ov.resultsetting;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @program: message
 * @description:
 * @author: ggmr
 * @create: 2018-08-31 14:12
 */
public class ReplyListResponse {
    public ReplyListResponse(CommentListResponseInfo raw) {
        this.raw = raw;
    }

    @JsonProperty("raw")
    private CommentListResponseInfo raw;
}
