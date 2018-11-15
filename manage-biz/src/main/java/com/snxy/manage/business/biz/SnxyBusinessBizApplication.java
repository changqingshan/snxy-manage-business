package com.snxy.manage.business.biz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Created by 24398 on 2018/11/15.
 */
@SpringBootApplication
@EnableFeignClients
public class SnxyBusinessBizApplication {

    public static void main(String[] args) {
        SpringApplication.run(SnxyBusinessBizApplication.class, args);
    }
}
