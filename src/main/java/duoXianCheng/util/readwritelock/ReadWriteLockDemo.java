package duoXianCheng.util.readwritelock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁示例
 * ReadWriteLock是一个接口，只定义了两个方法：readLock() writeLock()
 * 读与读的时候使其异步执行，读与写、写与写的时候使其同步执行。可用在读多写少的场景，极大地提升效率
 * ReentrantReadWriteLock是该接口的唯一实现类
 * <p>
 * 与SyncDemo对比学习
 * Created by MIN.WU.JUN on 2019/12/13
 */
public class ReadWriteLockDemo {
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private void read(Thread thread) {
        readWriteLock.readLock().lock();
        try {
            long start = System.currentTimeMillis();
            while (System.currentTimeMillis() - start <= 10) {
                System.out.println(thread.getName() + "正在进行读操作");
            }
            System.out.println(thread.getName() + "读操作完毕");
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    private void write(Thread thread) {
        readWriteLock.writeLock().lock();
        try {
            long start = System.currentTimeMillis();
            while (System.currentTimeMillis() - start <= 10) {
                System.out.println(thread.getName() + "正在进行写操作");
            }
            System.out.println(thread.getName() + "写操作完毕");
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public static void main(String[] args) {
        final ReadWriteLockDemo test = new ReadWriteLockDemo();
        //读与读：结果是异步执行
        new Thread(() -> test.read(Thread.currentThread())).start();
        new Thread(() -> test.read(Thread.currentThread())).start();

        //读与写：结果是同步执行
        new Thread(() -> test.read(Thread.currentThread())).start();
        new Thread(() -> test.write(Thread.currentThread())).start();

        //写与写：结果是同步执行
        new Thread(() -> test.write(Thread.currentThread())).start();
        new Thread(() -> test.write(Thread.currentThread())).start();
    }
}
