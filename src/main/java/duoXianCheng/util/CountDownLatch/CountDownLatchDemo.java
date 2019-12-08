package duoXianCheng.util.CountDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * 闭锁
 * 用于A线程等待其他线程执行完成之后，A才开始继续执行
 */
public class CountDownLatchDemo {

    private static final int SIZE = 5;

    private static final CountDownLatch countDownLatch = new CountDownLatch(SIZE);

    private static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "-开始执行");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-执行完毕");
            countDownLatch.countDown();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < SIZE; i++) {
            new MyThread().start();
        }
//
//        System.out.println("主线程等待中...");
//        countDownLatch.await();
//        System.out.println("主线程执行完毕");

        new Thread(() -> {
            System.out.println("业务线程执行中");
            System.out.println("业务线程开始等待其他线程执行完毕");
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("业务线程执行完毕");
        }).start();

    }

}
