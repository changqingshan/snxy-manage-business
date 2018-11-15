package com.snxy.manage.business.web;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by 24398 on 2018/11/15.
 */
@SpringCloudApplication
@ComponentScan({"com.snxy.manage.business.web","com.snxy.manage.business.biz","com.snxy.manage.business.dao"})
public class SnxyManageBusinessWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(SnxyManageBusinessWebApplication.class, args);
    }
}
