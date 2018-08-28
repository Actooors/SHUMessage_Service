package com.shu.message.model.ov.resultsetting;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @program: message
 * @description:
 * @author: ggmr
 * @create: 2018-08-28 20:48
 */
public class CommentListResponseInfo {
    @JsonProperty("blockName")
    private String blockName;
    @JsonProperty("cards")
    private List<CommentInfo> cards;

    public CommentListResponseInfo(String blockName) {
        this.blockName = blockName;
    }

    public CommentListResponseInfo(String blockName, List<CommentInfo> cards) {
        this.blockName = blockName;
        this.cards = cards;
    }
}
