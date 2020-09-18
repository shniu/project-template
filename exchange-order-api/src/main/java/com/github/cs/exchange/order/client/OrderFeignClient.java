package com.github.cs.exchange.order.client;

import com.github.cs.exchange.order.OrderConstant;
import com.github.cs.exchange.order.dto.OrderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author niushaohan
 * @date 2020/5/22 12
 */
@FeignClient(name = OrderConstant.SERVICE_NAME, path = "/api/v1")
public interface OrderFeignClient {
    @GetMapping(value = "/order/{orderId}")
    OrderDto getOrder(@PathVariable Long orderId);
}
