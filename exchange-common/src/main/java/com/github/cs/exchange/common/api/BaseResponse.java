package com.github.cs.exchange.common.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author niushaohan
 * @date 2020/5/22 07
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaseResponse {
    @Builder.Default
    private ResultCode code = ResultCode.SUCCESS;
    private String message;

    public boolean success() {
        return ResultCode.SUCCESS == code;
    }
}
