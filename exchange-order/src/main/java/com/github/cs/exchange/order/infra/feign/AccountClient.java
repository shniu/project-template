package com.github.cs.exchange.order.infra.feign;

import com.github.cs.exchange.order.infra.feign.dto.AccountResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author niushaohan
 * @date 2021/5/17 10
 */
@FeignClient(name = "ex-account-srv", path = "/api/v1")
public interface AccountClient {

    @GetMapping("/account/{userId}")
    AccountResponse queryAccountDetail(@PathVariable String userId);
}
