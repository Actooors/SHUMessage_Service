package com.shu.message.model.ov.resultsetting;

import lombok.Data;

/**
 * @program: message
 * @description:
 * @author: ggmr
 * @create: 2018-08-31 16:48
 */
@Data
public class IfreamResultInfo {
    Boolean exist;

    public IfreamResultInfo(Boolean exist) {
        this.exist = exist;
    }
}
