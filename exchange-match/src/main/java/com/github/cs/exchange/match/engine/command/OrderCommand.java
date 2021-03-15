package com.github.cs.exchange.match.engine.command;

import com.github.cs.exchange.match.engine.common.IOrder;
import com.github.cs.exchange.match.engine.common.OrderAction;
import com.github.cs.exchange.match.engine.common.OrderType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author niushaohan
 * @date 2021/3/1 11
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderCommand implements IOrder {
    @Getter
    private OrderCommandType commandType;

    private long orderId;
    private long uid;
    private String symbol;

    private BigDecimal price;
    private BigDecimal amount;

    private OrderAction action;
    @Getter
    private OrderType orderType;
    private long timestamp;

    @Override
    public long orderId() {
        return this.orderId;
    }

    @Override
    public long uid() {
        return this.uid;
    }

    @Override
    public String symbol() {
        return this.symbol;
    }

    @Override
    public BigDecimal price() {
        return this.price;
    }

    @Override
    public BigDecimal amount() {
        return this.amount;
    }

    @Override
    public BigDecimal filled() {
        return BigDecimal.ZERO;
    }

    @Override
    public OrderAction getAction() {
        return this.action;
    }

    @Override
    public long getTimestamp() {
        return this.timestamp;
    }
}
