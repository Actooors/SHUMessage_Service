package com.shu.message.model.ov.ResultSetting;

import lombok.Data;

import java.util.List;

/**
 * @program: message
 * @description:
 * @author: ggmr
 * @create: 2018-08-28 15:17
 */
public class NewsResponse {
    private List<NewsResponseInfo> cards;
    private int nums;

//    public NewsResponse(List<NewsResponseInfo> cards, int nums) {
//        this.cards = cards;
//        this.nums = nums;
//    }

    public List<NewsResponseInfo> getCards() {
        return cards;
    }

    public void setCards(List<NewsResponseInfo> cards) {
        this.cards = cards;
    }

    public int getNums() {
        return nums;
    }

    public void setNums(int nums) {
        this.nums = nums;
    }
}
