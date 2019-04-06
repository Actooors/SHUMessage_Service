package com.shu.message.model.ov.resultsetting;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @program: message
 * @description:
 * @author: 0GGmr0
 * @create: 2019-03-28 13:21
 */
@Data
public class NewsResponseModify {
    @JsonProperty("cards")
    private List<NewsResponseInfo> cards;
    @JsonProperty("nums")
    private int nums;
    private Date sendTime;

    public NewsResponseModify(List<NewsResponseInfo> cards, int nums, Date sendTime) {
        this.cards = cards;
        this.nums = nums;
        this.sendTime = sendTime;
    }
}
