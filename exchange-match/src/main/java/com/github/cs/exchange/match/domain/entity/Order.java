package com.github.cs.exchange.match.domain.entity;

import com.github.cs.exchange.common.domain.valueobject.Side;

import java.math.BigDecimal;

/**
 * 交易委托单.
 *
 * @author niushaohan
 * @date 2020/8/25 13
 */
public class Order {
    /**
     * Order Id.
     */
    private long orderId;

    /**
     * User Id.
     */
    private long userId;

    /**
     * Buy or Sell.
     */
    private Side side;

    /**
     * Trading pair, e.g. BTC_ETH, BTC_BCH.
     */
    private String symbol;

    private BigDecimal price;
    private BigDecimal amount;

    private long createdAt;
}
