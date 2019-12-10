package duoXianCheng.util.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用显示锁的范式
 * synchronized：内置锁，以前效率不好，但是现在经过优化后效率其实也不错。如果在不需要Lock的3个特性的时候，可以就用这个。使用简单
 * Lock：获取锁的时候可以被中断、超时获取锁、尝试获取锁
 * ReentrantLock：可重入锁
 *
 * 公平锁：先获取，先满足。反之，就是非公平锁（可以插队）
 */
public class LockDemo {

    private Lock lock = new ReentrantLock();
    private int count;

    public void increament() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }

    public synchronized void increament2() {
        count++;
    }
}
