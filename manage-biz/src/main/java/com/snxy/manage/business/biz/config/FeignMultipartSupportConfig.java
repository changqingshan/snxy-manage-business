package com.snxy.manage.business.biz.config;

import feign.codec.Encoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignMultipartSupportConfig {

    @Bean
    public Encoder multipartFormEncoder() {
        return new FeignMultipartEncoder();
    }

    @Bean
    public feign.Logger.Level multipartLoggerLevel() {
        return feign.Logger.Level.FULL;
    }
}

