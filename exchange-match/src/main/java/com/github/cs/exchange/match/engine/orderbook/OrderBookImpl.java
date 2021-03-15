package com.github.cs.exchange.match.engine.orderbook;

import com.github.cs.exchange.match.engine.command.CommandResult;
import com.github.cs.exchange.match.engine.command.OrderCommand;
import com.github.cs.exchange.match.engine.common.OrderAction;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.TreeMap;

/**
 * @author niushaohan
 * @date 2021/3/2 00
 */
public class OrderBookImpl implements OrderBook {

    // Ask buckets -> sell buckets (price:orders with same price)
    private final TreeMap<BigDecimal, OrdersBucket> askBuckets;
    // Bid buckets -> buy buckets
    private final TreeMap<BigDecimal, OrdersBucket> bidBuckets;

    private boolean logDebug;

    public OrderBookImpl() {
        askBuckets = new TreeMap<>();
        bidBuckets = new TreeMap<>();

        logDebug = true;
    }

    @Override
    public void newOrder(OrderCommand cmd) {
        // 需要处理 GTC, FOK, IOC, Post-only 类型的单子
        // 市价单
        // Stop Limit Order

        if (Objects.isNull(cmd)) {
            return;
        }

        switch (cmd.getOrderType()) {
            case GTC:
                placeGtcOrder(cmd);
                break;
            case POST_ONLY:
                break;
            case FOK:
                break;
            case IOC:
                break;
            default:
                throw new RuntimeException("");
        }

//        switch (cmd.getCommandType()) {
//            case PLACE_ORDER:
//                // 下单
//                placeOrder(cmd);
//                break;
//            case MOVE_ORDER:
//                // move
//                break;
//            case REDUCE_ORDER:
//                // reduce
//                break;
//            default:
//                throw new RuntimeException("Not supported command type: " + cmd.getCommandType());
//        }
    }

    void placeGtcOrder(OrderCommand cmd) {
        final OrderAction action = cmd.getAction();
        final BigDecimal price = cmd.price();
        final BigDecimal amount = cmd.amount();


    }

    @Override
    public CommandResult cancelOrder(OrderCommand cmd) {
        return null;
    }

    @Override
    public CommandResult moveOrder(OrderCommand cmd) {
        return null;
    }

    @Override
    public CommandResult reduceOrder(OrderCommand cmd) {
        return null;
    }
}
