package com.shumsg;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@MapperScan("com.shumsg.dao")
public class ShumsgApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShumsgApplication.class, args);
    }

}
