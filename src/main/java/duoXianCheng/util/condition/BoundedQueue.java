package duoXianCheng.util.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用Condition实现有界队列
 * Created by MIN.WU.JUN on 2020/1/16
 */
public class BoundedQueue<T> {
    //数组队列
    private Object[] items;
    //添加下标
    private int addIndex;
    //删除下标
    private int removeIndex;
    //当前队列数据数量
    private int count;
    //互斥锁
    private Lock lock = new ReentrantLock();
    //队列不为空的条件
    private Condition notEmpty = lock.newCondition();
    //队列没有满的条件
    private Condition notFull = lock.newCondition();

    public BoundedQueue(int size) {
        items = new Object[size];
    }

    //添加一个元素，如果数组满了，添加线程进入等待状态，直到有“空位”
    public void add(T t) {
        lock.lock();
        try {
            while (count == items.length)
                notFull.wait();
            items[addIndex] = t;
            if (++addIndex == items.length)
                addIndex = 0;
            ++count;
            //唤醒一个等待删除的线程
            notEmpty.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    //由头部删除一个元素，如果数组空，则删除线程进入等待状态，知道有新元素加入
    public T remove() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0) {
                notEmpty.await();
            }
            Object res = items[removeIndex];
            if (++removeIndex == items.length)
                removeIndex = 0;
            --count;
            //唤醒一个等待插入的线程
            notFull.signal();
            return (T) res;
        } finally {
            lock.unlock();
        }
    }
}
