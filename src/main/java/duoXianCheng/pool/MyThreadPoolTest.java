package duoXianCheng.pool;

import java.util.Random;

public class MyThreadPoolTest {

    public static void main(String[] args) throws InterruptedException {
        //创建线程池
        MyThreadPool myThreadPool = new MyThreadPool(3, 0);
        myThreadPool.execute(new MyTask("A"));
        myThreadPool.execute(new MyTask("B"));
        myThreadPool.execute(new MyTask("C"));
        myThreadPool.execute(new MyTask("D"));
        myThreadPool.execute(new MyTask("E"));
        System.out.println(myThreadPool);
        Thread.sleep(10000);
        myThreadPool.destory(); // 所有线程都执行完毕后才销毁
        System.out.println(myThreadPool);
    }

    static class MyTask implements Runnable {
        private String name;
        private Random r = new Random();

        public MyTask(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(r.nextInt(1000) + 2000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getId() + " sleep Interrupted:" +
                        Thread.currentThread().isInterrupted());
            }
            System.out.println("任务 " + name + " 完成");
        }
    }
}
