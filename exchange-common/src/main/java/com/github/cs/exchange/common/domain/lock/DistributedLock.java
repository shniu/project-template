package com.github.cs.exchange.common.domain.lock;

/**
 * @author niushaohan
 * @date 2020/8/28 13
 */
public interface DistributedLock {
    /**
     * 尝试加锁.
     *
     * @param ts      当前加锁的时间戳
     * @param seconds 持有锁的时间
     * @return true if lock succeed else false
     */
    boolean tryLock(long ts, int seconds);

    /**
     * 是否已经获取到锁.
     *
     * @return true if lock succeed else false
     */
    boolean isLocked();

    /**
     * 更新锁的过期时间.
     *
     * @param ts      当前时间戳
     * @param seconds 更新持有锁的时间 (续期)
     * @return true if update succeed else false
     */
    boolean updateLock(long ts, int seconds);

    /**
     * 释放锁.
     */
    void unlock();

    /**
     * 清理过期的锁.
     *
     * @param ts 当前时间戳
     * @return true if clear succeed else false
     */
    boolean clearExpiredLock(long ts);
}
