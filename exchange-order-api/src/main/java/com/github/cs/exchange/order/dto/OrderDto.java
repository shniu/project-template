package com.github.cs.exchange.order.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * @author niushaohan
 * @date 2020/5/22 12
 */
@Accessors(fluent = true)
@Data
public class OrderDto {
    private Long orderId;
    private Long userId;
    private String symbol;
    private String type;
    private BigDecimal amount;
    private BigDecimal price;
    private long createdAt;
}
