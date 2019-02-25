package com.shu.message.dto.response.newsresponseinfo;

import lombok.Data;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: message
 * @description:
 * @author: 0GGmr0
 * @create: 2019-02-25 21:55
 */
@Data
public class Media {
    private String type;
    private String title;
    private String value;
    private List<String> imgs;

    public Media(int type, String ... value) {
        if (type == 1) {
            this.type = "url";
            this.title = value[0];
            this.value= value[1];
            this.imgs = new LinkedList<>();
        } else {
            this.type = "img";
            this.title = "";
            this.value = "";
            String[] imgList = value[0].split("\\|");
            this.imgs = Arrays.asList(imgList);
        }
    }
}
