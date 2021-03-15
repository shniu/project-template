package com.github.cs.exchange.match.engine.orderbook;

import com.github.cs.exchange.match.engine.command.CommandResult;
import com.github.cs.exchange.match.engine.command.OrderCommand;

/**
 * Order book.
 * 一个 OrderBook 代表了一个币对(or 交易标的)涉及的所有方面，如挂单列表、执行撮合、撤销订单，输出撮合结果、数据快照等
 *
 * @author niushaohan
 * @date 2021/2/26 17
 */
public interface OrderBook {
    /**
     * 处理新的委托单.
     * 依赖于特定的价格，新的委托单会和在订单簿里相反方向的 GTC 订单匹配。
     * 如果有剩余量未匹配：
     * IOC - 会取消掉未匹配的
     * GTC - 添加一个新的 limit order 到订单簿
     * <p>
     * 如果是 post-only 订单：挂单或者取消
     *
     * @param cmd order to match / place
     */
    void newOrder(OrderCommand cmd);

    /**
     * 取消委托单.
     *
     * @param cmd order to cancel
     * @return MATCHING_UNKNOWN_ORDER_ID if order was not found, otherwise SUCCESS
     */
    CommandResult cancelOrder(OrderCommand cmd);

    /**
     * Move order.
     * newPrice - new price (if 0 or same - order will not moved)
     *
     * @param cmd order command
     * @return MATCHING_UNKNOWN_ORDER_ID if order was not found, otherwise SUCCESS
     */
    CommandResult moveOrder(OrderCommand cmd);

    /**
     * Decrease the size of the order by specific number of lots.
     *
     * @param cmd order command
     * @return MATCHING_UNKNOWN_ORDER_ID if order was not found, otherwise SUCCESS
     */
    CommandResult reduceOrder(OrderCommand cmd);

    @FunctionalInterface
    interface OrderBookFactory {
        OrderBook create();
    }
}
