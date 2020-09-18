package com.github.cs.exchange.common.domain.lock.po;

import lombok.Data;

/**
 * @author niushaohan
 * @date 2020/8/28 13
 */
@Data
public class Lock {
    // lockName is primary key
    private String lockName;
    private long expiredAt;
    private String owner;
}
