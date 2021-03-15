package com.github.cs.exchange.match.engine.command;

import lombok.Builder;

/**
 * @author niushaohan
 * @date 2021/2/26 18
 */
@Builder
public class CommandResult {
    private ResultCode result;

    public ResultCode getResult() {
        return result;
    }

    public boolean isSuccess() {
        return ResultCode.SUCCESS.equals(result);
    }

    public boolean equalsTo(ResultCode target) {
        return target != null && target.equals(result);
    }

    enum ResultCode {
        NEW(0),

        SUCCESS(100),
        ACCEPTED(110),

        AUTH_INVALID_USER(-1001),
        ;

        private int code;

        ResultCode(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }
    }
}
