package duoXianCheng.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 学习JDK提供的线程池类ThreadPoolExecutor
 */
public class ThreadPoolExecutorDemo {

    /**
     * ThreadPoolExecutor是JDK所有线程池实现的父类
     *
     * 各个参数的含义：
     *
     * int corePoolSize：
     *      线程池中核心线程数量，小于corePoolSize创建新线程，等于corePoolSize这个任务会保存
     *      到BlockingQueue
     *
     * int maximumPoolSize：
     *      允许的最大线程数，如果BlockingQueue也满了，并且小于maximumPoolSize的时候就会再次创建新线程
     *
     * long keepAliveTime：
     *      线程空闲以后，存活的时间，这个参数只在大于corePoolSize时才有用
     *
     * TimeUnit unit：
     *      存活时间的单位
     *
     * BlockingQueue<Runnable> workQueue：
     *      保存任务的阻塞队列
     *
     * ThreadFactory threadFactory：
     *      创建线程的工厂，给新建的线程赋予名字
     *
     * RejectedExecutionHandler handler：
     *      饱和策略。饱和是指线程数量达到maximumPoolSize。有4种
     *      AbortPolicy：直接抛出异常，默认
     *      CallerRunsPolicy：用调用者所在线程来执行任务
     *      DiscardOldestPolicy：丢弃阻塞队列里面最老的任务（最靠前的任务）
     *      DiscardPolicy：把当前任务直接丢弃
     *      也可以实现自己的饱和策略（实现RejectedExecutionHandler接口）
     *
     *
     * 提交任务：
     *      public void execute(Runnable command); 不需要返回值
     *      public <T> Future<T> submit(Callable<T> task); 有返回值
     *
     * 关闭线程池：
     *      shutdown(); 设置线程池的状态，只会中断所有还没有执行任务的线程
     *      shutdownNow(); 不仅设置线程池的状态，还会尝试停止正在运行/暂停的线程
     *
     * 合理配置线程池：
     *      根据任务的性质来：计算密集型（CPU）、IO密集型、混合型
     *
     *      计算密集型：加密、大数分解、正则...线程数适当小一点，最大线程数量推荐：机器的CPU数量+1。
     *      为什么+1？页缺失
     *
     *      IO密集型：读取文件、数据库连接、网络通讯...线程数适当大一点，机器的CPU核心数*2
     *
     *      混合型：尽量拆分。如果IO密集型>>计算密集型，拆分意义不大
     *
     *      队列的选择上，应该使用有界，无界队列可能会导致内存溢出
     *
     */

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Executors.newCachedThreadPool();
        Executors.newSingleThreadExecutor();
        Executors.newWorkStealingPool();
        Executors.newScheduledThreadPool(3);
        Executors.newSingleThreadScheduledExecutor();
    }

}
