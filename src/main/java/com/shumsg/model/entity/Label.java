package com.shumsg.model.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Label {
    private String id;

    private String name;

    private LocalDateTime createTime;

    private LocalDateTime deleteTime;

}