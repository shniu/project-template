package com.github.cs.exchange.order;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author niushaohan
 * @date 2020/5/22 07
 */
@SpringBootApplication
@MapperScan(value = {"com.github.cs.exchange.order.infra"})
@Slf4j
public class ExchangeOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExchangeOrderApplication.class, args);
        log.info("Exchange Order Application started !!!");
    }
}
