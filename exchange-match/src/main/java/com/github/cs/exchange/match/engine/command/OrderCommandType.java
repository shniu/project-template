package com.github.cs.exchange.match.engine.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;

/**
 * @author niushaohan
 * @date 2021/3/2 18
 */
@AllArgsConstructor
@Getter
public enum OrderCommandType {
    PLACE_ORDER((byte) 1, true),
    CANCEL_ORDER((byte) 2, true),
    MOVE_ORDER((byte) 3, true),
    REDUCE_ORDER((byte) 4, true),
    ;

    private byte code;
    private boolean mutate;

    public static OrderCommandType fromCode(byte code) {
        final OrderCommandType result = codes.get(code);
        if (result == null) {
            throw new IllegalArgumentException("Unknown order command type code:" + code);
        }
        return result;
    }

    private static HashMap<Byte, OrderCommandType> codes = new HashMap<>();

    static {
        for (OrderCommandType x : values()) {
            codes.put(x.code, x);
        }
    }
}
