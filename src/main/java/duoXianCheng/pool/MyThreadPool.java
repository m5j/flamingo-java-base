package duoXianCheng.pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 自己实现一个简单的线程池
 * 窥探线程池原理
 */
public class MyThreadPool {
    //线程池中默认线程个数
    private static int WORK_NUM = 5;
    //队列任务默认个数
    private static int TASK_COUNT = 100;

    //工作线程组
    private WorkThread[] workThreads;

    //任务队列，作为一个缓冲
    private final BlockingQueue<Runnable> taskQueue;
    //希望启动的线程数量
    private final int workNum;

    public MyThreadPool() {
        this(WORK_NUM, TASK_COUNT);
    }

    public MyThreadPool(int workNum, int taskCount) {
        if (workNum <= 0) workNum = WORK_NUM;
        if (taskCount <= 0) taskCount = TASK_COUNT;

        this.workNum = workNum;
        this.taskQueue = new ArrayBlockingQueue<>(taskCount);

        workThreads = new WorkThread[workNum];
        for (int i = 0; i < workNum; i++) {
            workThreads[i] = new WorkThread();
            workThreads[i].start();
        }
    }

    //执行任务，其实只是加入任务队列
    public void execute(Runnable task) {
        try {
            taskQueue.put(task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //销毁线程池
    public void destory() {
        System.out.println("ready destory pool...");
        for (int i = 0; i < workNum; i++) {
            workThreads[i].stopWork();
            workThreads[i] = null; //帮助GC
        }
    }


    /**
     * 工作线程，内部类
     */
    private class WorkThread extends Thread {
        @Override
        public void run() {
            Runnable r = null;
            try {
                //只要未被中断，一直循环等待任务的到来，到来了就执行任务
                while (!isInterrupted()) {
                    //重点
                    //该方法阻塞，线程池启动的时候会卡在这里，直到用户把任务塞进了线程池
                    //实际上就是put进了这个任务队列taskQueue，然后take方法就能取到任务，继续向下执行
                    r = taskQueue.take();
                    if (r != null) {
                        System.out.println("线程 " + getId() + " 准备执行：" + r);
                        r.run(); //注意是调用run方法不是start方法，也就是说这里是一次普通方法调用
                    }
                    r = null; // 帮助GC
                }
            } catch (InterruptedException e) {
                System.out.println("抛出了异常");
            }
        }

        public void stopWork() {
            interrupt();
        }

    }

}
