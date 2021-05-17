package com.github.cs.exchange.order.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author niushaohan
 * @date 2020/5/22 12
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDto {
    private Long orderId;
    private Long userId;
    private String symbol;
    private String type;
    private BigDecimal amount;
    private BigDecimal price;
    private long createdAt;
}
