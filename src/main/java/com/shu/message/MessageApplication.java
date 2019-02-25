package com.shu.message;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@RequestMapping("")
@MapperScan("com.shu.message.dao")
public class MessageApplication {


    @GetMapping("")
    public String getMsg() {
        return "s";
    }

    public static void main(String[] args) {
        SpringApplication.run(MessageApplication.class, args);
    }

}
