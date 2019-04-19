package com.shumsg.model.front;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * @program: shumsg
 * @description: 爬虫端爬取新闻的接口
 * @author: 0GGmr0
 * @create: 2019-04-17 10:06
 */
@Data
public class SpiderNewsInfo {
    @NotBlank(message = "发布者主键id不能为空")
    private String userId; // 发布者主键id
    @NotBlank(message = "新闻的标题不能为空")
    private String mediaTitle; // 新闻的标题
    @NotBlank(message = "新闻的url不能为空")
    private String newsUrl; // 新闻的url
    @NotBlank(message = "新闻的标签Id(爬虫直接获取的标签)不能为空")
    private String newsLabelId; // 新闻的标签Id(爬虫直接获取的标签)
    @NotBlank(message = "爬虫获取的新闻的内容不能为空")
    private String contentFromScrapy; // 爬虫获取的新闻的内容
    @NotBlank(message = "md5不能为空")
    private String md5; // 验证爬虫唯一性的接口
    @NotNull(message = "时间不能为空")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime; // 新闻发布的时间
}
