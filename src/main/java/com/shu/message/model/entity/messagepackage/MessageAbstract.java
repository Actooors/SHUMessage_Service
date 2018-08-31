package com.shu.message.model.entity.messagepackage;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @program: message
 * @description:
 * @author: ggmr
 * @create: 2018-08-31 22:12
 */
@Data
public class MessageAbstract {
    private String userId;
    @JsonFormat(locale="zh", timezone = "GMT+8", pattern = "yyyy-MM-ddTHH:mm:ss")
    private Date createDate;
    private Integer commentNum;
    private Integer likeNum;
    private Integer sharesNum;
    private String content;
    private Integer type;
    private Integer tagId;
    private String tag;

}
