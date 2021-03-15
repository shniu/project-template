package com.github.cs.exchange.match.engine.config;

import com.github.cs.exchange.match.engine.orderbook.OrderBook;
import com.github.cs.exchange.match.engine.orderbook.OrderBookImpl;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * @author niushaohan
 * @date 2021/3/2 15
 */
@AllArgsConstructor
@Getter
@Builder
public final class PerformanceConfiguration {
    public static final PerformanceConfiguration DEFAULT = PerformanceConfiguration.baseBuilder().build();

    /**
     * Order book factory.
     */
    private OrderBook.OrderBookFactory orderBookFactory;

    public static PerformanceConfiguration.PerformanceConfigurationBuilder baseBuilder() {
        return builder()
                .orderBookFactory(OrderBookImpl::new);
    }
}
