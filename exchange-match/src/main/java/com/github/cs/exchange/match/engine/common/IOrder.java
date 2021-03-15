package com.github.cs.exchange.match.engine.common;

import java.math.BigDecimal;

/**
 * @author niushaohan
 * @date 2021/3/2 17
 */
public interface IOrder {
    long orderId();
    long uid();

    String symbol();
    BigDecimal price();
    BigDecimal amount();

    BigDecimal filled();

    OrderAction getAction();

    long getTimestamp();
}
