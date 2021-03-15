package com.github.cs.exchange.match.engine.common;

/**
 * @author niushaohan
 * @date 2021/3/1 10
 */
public enum OrderAction {
    // Ask
    SELL(0),

    // Bid
    BUY(1);

    private byte code;

    OrderAction(int code) {
        this.code = (byte) code;
    }

    public static OrderAction of(byte code) {
        switch (code) {
            case 0:
                return SELL;
            case 1:
                return BUY;
            default:
                throw new IllegalArgumentException("Unknown OrderAction code: " + code);
        }
    }

    public OrderAction opposite() {
        return SELL == this ? BUY : SELL;
    }
}
