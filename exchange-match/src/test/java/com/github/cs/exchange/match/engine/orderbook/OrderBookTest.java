package com.github.cs.exchange.match.engine.orderbook;

import com.github.cs.exchange.match.engine.config.MatchingEngineConfiguration;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author niushaohan
 * @date 2021/3/1 13
 */
@Slf4j
public class OrderBookTest {

    @Test
    void test_placeOrder() {
        MatchingEngineConfiguration matchingEngineCfg = MatchingEngineConfiguration.defaultBuilder().build();

        OrderBook.OrderBookFactory orderBookFactory = matchingEngineCfg.getPerformanceCfg().getOrderBookFactory();

        OrderBook orderBook = orderBookFactory.create();

        orderBook.newOrder(null);
    }

    @Test
    void test_treeMap() {
        Comparator<Order> SORT_SELL = new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                // 价格优先，卖单价格高的排在前边
                int cmp = o1.price.compareTo(o2.price);
                if (cmp == 0) {
                    // 然后时间优先
                    return Long.compare(o1.orderId, o2.orderId);
                }
                return cmp;
            }
        };

        Comparator<Order> SORT_BUY = new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                // 价格优先，买单价格高的排在后边
                int cmp = o2.price.compareTo(o1.price);
                if (cmp == 0) {
                    // 然后时间优先
                    return Long.compare(o1.orderId, o2.orderId);
                }
                return cmp;
            }
        };

        // sell: 价格优先是价格越低越优先，出价最低的排在第一个
        // price -> order
        TreeMap<Long, Order> askBuckets = new TreeMap<>();
        // buy: 价格优先是价格越高越优先，出价最高的排在第一个
        // price -> order
        TreeMap<Long, Order> bidBuckets = new TreeMap<>(Collections.reverseOrder());

        Order o1 = Order.builder()
                .orderId(11)
                .symbol("BTC_USD")
                .price(new BigDecimal("10000"))
                .amount(new BigDecimal("10"))
                .orderType("Limit Order")
                .action("Buy")
                .build();

        Order o2 = Order.builder()
                .orderId(12)
                .symbol("BTC_USD")
                .price(new BigDecimal("9999"))
                .amount(new BigDecimal("5"))
                .orderType("Limit Order")
                .action("Buy")
                .build();

        Order o3 = Order.builder()
                .orderId(13)
                .symbol("BTC_USD")
                .price(new BigDecimal("10000"))
                .amount(new BigDecimal("2"))
                .orderType("Limit Order")
                .action("Buy")
                .build();

        // Place an limit order: @10000 USD buy 10 BTC
        bidBuckets.put(10000L, o1);

        // Place an limit order: @9999 USD buy 5 BTC
        bidBuckets.put(9999L, o2);

        // Place an limit order: @10000 USD buy 2 BTC
        bidBuckets.put(10000L, o3);

        log.info("bidBuckets.size is {}", bidBuckets.size());
        log.info("bidBuckets.firstEntry orderId is {}", bidBuckets.firstEntry().getValue().getOrderId());

        bidBuckets.remove(bidBuckets.firstKey());
        log.info("bidBuckets.secondEntry orderId is {}", bidBuckets.firstEntry().getValue().getOrderId());
    }

    @Data
    @Builder
    static class Order {
        private long orderId;
        private String symbol;
        private BigDecimal price;
        private BigDecimal amount;
        private String orderType;
        private String action;
    }
}