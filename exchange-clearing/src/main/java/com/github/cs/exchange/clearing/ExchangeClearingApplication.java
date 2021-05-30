package com.github.cs.exchange.clearing;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author niushaohan
 * @date 2021/5/17 13
 */
@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class ExchangeClearingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExchangeClearingApplication.class, args);
        log.info("ExchangeClearing service started !!!");
    }
}
