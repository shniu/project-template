package com.github.cs.exchange.match.engine.common;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author niushaohan
 * @date 2021/3/2 17
 */
@Slf4j
class OrderTest {

    @Test
    void test_Order() {
        Order order = Order.builder()
                .orderId(1000)
                .action(OrderAction.BUY)
                .price(new BigDecimal("1600"))
                .amount(new BigDecimal("1.2"))
                .filled(new BigDecimal(0))
                .uid(2021)
                .symbol("ETH/USD")
                .timestamp(System.currentTimeMillis())
                .build();

        log.info("toString -> {}, stateHash -> {}", order, order.stateHash());
    }

}