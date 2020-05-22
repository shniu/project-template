package com.github.cs.exchange.common.api;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.servlet.http.HttpServletResponse;

/**
 * @author niushaohan
 * @date 2020/5/22 07
 */
@Getter
@AllArgsConstructor
public enum ResultCode {
    SUCCESS(HttpServletResponse.SC_OK, "Success")
    ;

    final int code;
    final String msg;
}
