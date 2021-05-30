package com.github.cs.exchange.order.config;

import com.github.cs.exchange.order.infra.feign.AuthRequestInterceptor;
import feign.Logger;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author niushaohan
 * @date 2021/5/17 11
 */
// @Configuration
public class FeignConfig {

    @Bean
    public Logger.Level feignLoggerLevel() {
        // 开发测试时使用 FULL
        // 生产追踪问题使用 BASIC
        // 追求性能使用 NONE
        return Logger.Level.FULL;
    }

    @Bean
    public AuthRequestInterceptor authRequestInterceptor() {
        return new AuthRequestInterceptor();
    }
}
