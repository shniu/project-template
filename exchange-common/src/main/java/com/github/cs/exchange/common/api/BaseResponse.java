package com.github.cs.exchange.common.api;

import lombok.Builder;
import lombok.Data;

/**
 * @author niushaohan
 * @date 2020/5/22 07
 */
@Data
@Builder
public class BaseResponse {
    @Builder.Default
    private ResultCode code = ResultCode.SUCCESS;
    private String message;

    public boolean success() {
        return ResultCode.SUCCESS == code;
    }
}
