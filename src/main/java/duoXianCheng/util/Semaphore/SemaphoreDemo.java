package duoXianCheng.util.Semaphore;


import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

    /**
     * Semaphore中文翻译是【信号机】
     * 限制只能同时进入多少个线程
     * acquire方法申请准入凭证 release方法归还准入凭证
     */
    private static Semaphore semaphore = new Semaphore(1);

    private static class MyThread extends Thread {
        @Override
        public void run() {
            try {
                semaphore.acquire(1);
                System.out.println("子线程进入-" + Thread.currentThread().getName());
                Thread.sleep(1000);
                System.out.println("子线程执行完毕-" + Thread.currentThread().getName());
                semaphore.release(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new MyThread().start();
        }
    }

}
