package com.github.cs.exchange.order.resource;

import com.github.cs.exchange.common.api.BaseResponse;
import com.github.cs.exchange.order.domain.OrderService;
import com.github.cs.exchange.order.dto.CreateOrderRequest;
import com.github.cs.exchange.order.dto.GetOrderResponse;
import com.github.cs.exchange.order.dto.OrderDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author niushaohan
 * @date 2020/8/25 14
 */
@RestController
@RequestMapping(value = "/api/v1")
public class OrderResource {
    private OrderService orderService;

    public OrderResource(final OrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * Place an order.
     */
    @PostMapping("/order")
    public BaseResponse placeOrder(@RequestBody final CreateOrderRequest createOrderRequest) {
        return BaseResponse.builder().build();
    }

    /**
     * Query an order.
     */
    @GetMapping("/order/{orderId}")
    public BaseResponse getOrder(@PathVariable final Long orderId) {
        OrderDto orderDto = orderService.queryOrder(orderId);
        return new GetOrderResponse(orderDto);
    }

    /**
     * Cancel an order.
     */
    @PutMapping("/order/{orderId}/cancel")
    public BaseResponse cancelOrder(@PathVariable final Long orderId) {
        return BaseResponse.builder().build();
    }
}
