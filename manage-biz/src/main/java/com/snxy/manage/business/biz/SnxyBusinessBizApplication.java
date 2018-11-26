package com.snxy.manage.business.biz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by 24398 on 2018/11/15.
 */
@SpringBootApplication
@EnableFeignClients
@ComponentScan({"com.snxy.manage.business.biz","com.snxy.manage.business.dao"})
public class SnxyBusinessBizApplication {

    public static void main(String[] args) {
        SpringApplication.run(SnxyBusinessBizApplication.class, args);
    }
}
