package com.github.cs.exchange.order.infra.feign.dto;

import com.github.cs.exchange.common.api.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author niushaohan
 * @date 2021/5/17 10
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class AccountResponse extends BaseResponse {
    private AccountDto account;
}
