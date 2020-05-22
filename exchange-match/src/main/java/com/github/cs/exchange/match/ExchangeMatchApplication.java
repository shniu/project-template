package com.github.cs.exchange.match;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author niushaohan
 * @date 2020/5/22 10
 */
@SpringBootApplication
@Slf4j
public class ExchangeMatchApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExchangeMatchApplication.class, args);
        log.info("ExchangeMatchApplication started.");
    }
}
