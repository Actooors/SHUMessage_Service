package com.shumsg.model.back;

import lombok.Data;

/**
 * @program: shumsg
 * @description: 统一返回格式
 * @author: 0GGmr0
 * @create: 2019-04-10 18:27
 */

@Data
public class Result<T> {
    /**
     * 标识码
     */
    private Integer code;
    /**
     * 错误信息
     */
    private String message;
    /**
     * 数据
     */
    private T data;
}
