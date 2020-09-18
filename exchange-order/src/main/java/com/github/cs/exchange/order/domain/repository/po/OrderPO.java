package com.github.cs.exchange.order.domain.repository.po;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author niushaohan
 * @date 2020/8/25 22
 */
@Data
public class OrderPO {
    private Long orderId;

    private String symbol;

    /**
     * Order type.
     */
    private String type;
    private String side;
    private long userId;

    private BigDecimal amount;
    private BigDecimal filledAmount;
    private BigDecimal price;

    private BigDecimal fee;
    private BigDecimal triggerPrice;

    private long createdAt;
    private long updatedAt;
}
