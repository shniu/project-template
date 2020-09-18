package com.github.cs.exchange.common.domain.lock;

import com.github.cs.exchange.common.domain.lock.mapper.LockMapper;

/**
 * @author niushaohan
 * @date 2020/8/28 13
 */
public class DatabaseDistributedLock implements DistributedLock {
    private LockMapper lockMapper;

    public DatabaseDistributedLock(final LockMapper lockMapper) {
        this.lockMapper = lockMapper;
    }

    @Override
    public boolean tryLock(long ts, int seconds) {
        return false;
    }

    @Override
    public boolean isLocked() {
        return false;
    }

    @Override
    public boolean updateLock(long ts, int seconds) {
        return false;
    }

    @Override
    public void unlock() {

    }

    @Override
    public boolean clearExpiredLock(long ts) {
        return false;
    }
}
