package com.github.cs.exchange.match.engine.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author niushaohan
 * @date 2021/3/2 17
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order implements IOrder, StashHash {
    private long orderId;
    private long uid;
    private String symbol;
    private BigDecimal price;
    private BigDecimal amount;
    private long timestamp;

    private BigDecimal filled;

    private OrderAction action;

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
        return this.filled;
    }

    @Override
    public OrderAction getAction() {
        return this.action;
    }

    @Override
    public long getTimestamp() {
        return this.timestamp;
    }

    @Override
    public String toString() {
        return "Order[" + orderId + " " + (action == OrderAction.BUY ? "Buy" : "Sell")
                + " " + price + ":" + amount + " Filled:" + filled + " Uid:" + uid + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null) return false;
        if (!(o instanceof Order)) return false;

        Order other = (Order) o;

        return this.orderId == other.orderId
                && this.action == other.action
                && this.price.equals(other.price)
                && this.amount.equals(other.amount)
                && this.filled.equals(other.filled)
                && this.uid == other.uid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, uid, price, action, amount, filled);
    }

    @Override
    public int stateHash() {
        return hashCode();
    }
}
