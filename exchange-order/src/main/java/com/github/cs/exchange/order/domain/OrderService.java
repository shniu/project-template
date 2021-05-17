package com.github.cs.exchange.order.domain;

import com.github.cs.exchange.order.dto.OrderDto;
import com.github.cs.exchange.order.infra.feign.AccountClient;
import com.github.cs.exchange.order.infra.feign.dto.AccountDto;
import com.github.cs.exchange.order.infra.feign.dto.AccountResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author niushaohan
 * @date 2021/5/17 10
 */
@Service
@Slf4j
public class OrderService {

    private AccountClient accountClient;

    public OrderService(final AccountClient accountClient) {
        this.accountClient = accountClient;
    }

    public OrderDto queryOrder(final Long orderId) {
        // 根据 orderId 查询订单信息
        // 从请求上下文中获取到 userId
        AccountResponse accountResponse = accountClient.queryAccountDetail("666666");
        AccountDto account = accountResponse.getAccount();
        log.info("Account Service Response: {}", account);
        return OrderDto.builder()
                .orderId(orderId)
                .userId(666666L)
                .build();
    }
}
