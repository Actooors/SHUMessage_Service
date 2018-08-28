package com.shu.message.model.ov.resultsetting;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @program: message
 * @description:
 * @author: ggmr
 * @create: 2018-08-28 15:17
 */
public class NewsResponse {
    @JsonProperty("cards")
    private List<NewsResponseInfo> cards;
    @JsonProperty("nums")
    private int nums;

    public NewsResponse(List<NewsResponseInfo> cards, int nums) {
        this.cards = cards;
        this.nums = nums;
    }

}
