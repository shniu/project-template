package com.github.cs.exchange.clearing.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author niushaohan
 * @date 2021/5/17 13
 */
@Configuration
public class ClearingConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    @LoadBalanced
    public RestTemplate balancedRestTemplate() {
        return new RestTemplate();
    }
}
