package duoXianCheng.util.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用显示锁的范式
 * synchronized：内置锁，以前效率不好，但是现在经过优化后效率其实也不错。如果在不需要Lock的3个特性的时候，可以就用这个。使用简单
 * Lock：获取锁的时候可以被中断、超时获取锁、尝试获取锁
 * ReentrantLock：可重入锁
 * <p>
 * 公平锁：先获取，先满足。反之，就是非公平锁（可以插队）
 */
public class TryLockDemo {
    private Lock lock = new ReentrantLock();  //保证是同一把锁（同一个对象）

    public static void main(String[] args) {
        TryLockDemo lockDemo = new TryLockDemo();
        new Thread(() -> lockDemo.insert(Thread.currentThread())).start();
        new Thread(() -> lockDemo.insert(Thread.currentThread())).start();
    }


    private void insert(Thread thread) {
        if (lock.tryLock()) { //如果没有获取到锁，则返回false，并且不会再次获取锁了
            try {
                System.out.println(thread.getName() + "得到了锁");
                Thread.sleep(3000);
            } catch (Exception ignored) {

            } finally {
                System.out.println(thread.getName() + "释放了锁");
                lock.unlock(); //注意一定要放在finally块中
            }
        }
//        lock.lock();


    }
}
