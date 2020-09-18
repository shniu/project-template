package com.github.cs.exchange.order.domain.entity;

import lombok.Getter;

/**
 * @author niushaohan
 * @date 2020/8/25 13
 */
@Getter
public class OrderId {
    private long id;

    public OrderId(final long orderId) {
        this.id = orderId;
    }
}
