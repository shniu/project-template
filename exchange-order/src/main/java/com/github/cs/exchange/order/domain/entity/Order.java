package com.github.cs.exchange.order.domain.entity;

import com.github.cs.exchange.order.domain.OrderType;
import com.github.cs.exchange.common.domain.valueobject.Side;
import lombok.Getter;

import java.math.BigDecimal;

/**
 * 用户的交易委托单, 如下单/撤销单等.
 *
 * @author niushaohan
 * @date 2020/8/25 13
 */
@Getter
public class Order {
    private OrderId orderId;

    private long userId;
    private String symbol;
    private Side side;
    private OrderType orderType;

    private BigDecimal price;
    private BigDecimal amount;

    private long createdAt;
}
