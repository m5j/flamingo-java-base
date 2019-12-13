package duoXianCheng.cas;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * AtomicInteger使用示例
 * Created by MIN.WU.JUN on 2019/12/10
 */
public class AtomicIntegerDemo {
    private static AtomicInteger ai = new AtomicInteger(0);
    private static final CountDownLatch countDownLatch = new CountDownLatch(20000);

    private static class ThreadA extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                ai.incrementAndGet();
                countDownLatch.countDown();
            }
        }
    }

    private static class ThreadB extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                ai.incrementAndGet();
                countDownLatch.countDown();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new ThreadA().start();
        new ThreadB().start();

        Thread.sleep(1);
        System.out.println(ai.get());

        countDownLatch.await();
        System.out.println(ai);

    }
}
