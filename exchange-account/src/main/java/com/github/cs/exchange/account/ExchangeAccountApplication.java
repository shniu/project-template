package com.github.cs.exchange.account;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author niushaohan
 * @date 2021/5/17 10
 */
@SpringBootApplication
@Slf4j
public class ExchangeAccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExchangeAccountApplication.class, args);
        log.info("Exchange account service started !!!");
    }
}
