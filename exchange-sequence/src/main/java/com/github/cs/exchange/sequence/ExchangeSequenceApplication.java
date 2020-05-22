package com.github.cs.exchange.sequence;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author niushaohan
 * @date 2020/5/22 10
 */
@SpringBootApplication
@Slf4j
public class ExchangeSequenceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExchangeSequenceApplication.class, args);
        log.info("ExchangeSequenceApplication started.");
    }
}
