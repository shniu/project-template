package com.github.cs.exchange.account.resource.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author niushaohan
 * @date 2021/5/17 10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountDto {
    private String userId;
    private String accountId;

    private BigDecimal available;
    private BigDecimal frozen;
    private BigDecimal locked;
}
