package com.shu.message.model.ov.resultsetting;

import lombok.Data;

import java.util.List;

/**
 * @program: message
 * @description:
 * @author: ggmr
 * @create: 2018-08-28 21:30
 */


@Data
public class ReplyInfo {
    private int count;
    private List<RepresentativesInfo> representatives;

}
