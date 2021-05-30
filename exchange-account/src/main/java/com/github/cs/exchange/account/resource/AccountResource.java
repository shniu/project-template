package com.github.cs.exchange.account.resource;

import com.github.cs.exchange.account.resource.dto.AccountDto;
import com.github.cs.exchange.account.resource.dto.AccountResponse;
import com.github.cs.exchange.common.api.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author niushaohan
 * @date 2021/5/17 10
 */
@RestController
@RequestMapping("/api/v1")
@Slf4j
public class AccountResource {

    /**
     * Query an account detail using userId.
     *
     * @param userId user id
     * @return response for the detail account
     */
    @GetMapping("/account/{userId}")
    public AccountResponse queryAccountDetail(@PathVariable String userId,
                                              @RequestHeader(value = "checksum", required = false) String checksum) {
        log.info("Receive request: userId is {}, checksum is {}", userId, checksum);

        AccountDto accountDto = new AccountDto();
        // TODO
        return new AccountResponse(accountDto);
    }

    @GetMapping("/account/beat")
    public BaseResponse pingHello() {
        return BaseResponse.builder().build();
    }
}
