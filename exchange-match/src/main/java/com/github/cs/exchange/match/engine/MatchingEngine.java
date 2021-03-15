package com.github.cs.exchange.match.engine;

import com.github.cs.exchange.match.engine.command.OrderCommand;
import com.github.cs.exchange.match.engine.command.OrderCommandType;
import com.github.cs.exchange.match.engine.common.OrderAction;
import com.github.cs.exchange.match.engine.common.OrderType;
import com.github.cs.exchange.match.engine.config.MatchingEngineConfiguration;
import com.github.cs.exchange.match.engine.orderbook.OrderBook;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * 撮合引擎的核心启动类.
 *
 * @author niushaohan
 * @date 2021/3/2 18
 */
@Slf4j
public class MatchingEngine {
    private MatchingEngineConfiguration matchingEngineCfg;

    private boolean started = false;

    @Builder
    public MatchingEngine(final MatchingEngineConfiguration matchingEngineCfg) {
        log.info("Building matching engine from configuration: {}", matchingEngineCfg);
        this.matchingEngineCfg = matchingEngineCfg;
    }

    /**
     * 启动撮合引擎.
     */
    public synchronized void startup() {
        if (!started) {
            started = true;

            OrderBook.OrderBookFactory orderBookFactory = matchingEngineCfg.getPerformanceCfg().getOrderBookFactory();
            OrderBook orderBook = orderBookFactory.create();

            // Buy BTC/USDT @47823
            OrderCommand order1 = OrderCommand.builder()
                    .commandType(OrderCommandType.PLACE_ORDER)
                    .orderId(100L)
                    .uid(1010)
                    .symbol("BTC/USDT")
                    .price(new BigDecimal("47823"))
                    .amount(new BigDecimal("1.2"))
                    .action(OrderAction.BUY)
                    .orderType(OrderType.GTC)
                    .timestamp(System.currentTimeMillis())
                    .build();

            orderBook.newOrder(order1);
        }
    }

    /**
     * 立即关闭撮合引擎.
     */
    public void shutdown() {
        shutdown(-1, TimeUnit.MILLISECONDS);
    }

    /**
     * 关闭撮合引擎.
     *
     * @param timeout  超时时间
     * @param timeUnit 时间单位
     */
    public void shutdown(long timeout, TimeUnit timeUnit) {

    }
}
