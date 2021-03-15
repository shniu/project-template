package com.github.cs.exchange.match.engine.common;

/**
 * @author niushaohan
 * @date 2021/3/1 10
 */
public enum OrderType {
    // Good till Cancel
    GTC,

    // Immediate or Cancel
    IOC,

    // Fill or kill
    FOK,

    // Post only
    POST_ONLY
}
