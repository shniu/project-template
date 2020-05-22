package com.github.cs.exchange.order.infra.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * 客户的委托单
 *
 * @author niushaohan
 * @date 2020/5/22 11
 */
@Data
@Accessors(chain = true)
public class Order {
    private Long orderId;
    private String symbol;
    private String type;
    private Long userId;
    private BigDecimal amount;
    private BigDecimal price;
    private BigDecimal fee;
    private BigDecimal triggerPrice;
    private long createdAt;
    private long updatedAt;
}
