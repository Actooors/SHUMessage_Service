package com.shu.message.model.ov.resultsetting;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @program: message
 * @description:
 * @author: ggmr
 * @create: 2018-08-28 20:47
 */
public class CommentListResponse {
    public CommentListResponse(List<CommentListResponseInfo> raw) {
        this.raw = raw;
    }

    @JsonProperty("raw")
    private List<CommentListResponseInfo> raw;
}
