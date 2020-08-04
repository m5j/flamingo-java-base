package duoXianCheng.syn;

/**
 * 内置锁
 */
public class SynchronizedDemo {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new MyThread()).start();
        }
    }

    static class MyThread implements Runnable {
        @Override
        public void run() {
//            method1();
            method2();
        }
    }

    //把该方法加上内置锁，同时只能有一个线程进入该方法
    private static synchronized void method1() {
        String name = Thread.currentThread().getName();
        for (int i = 0; i < 5; i++) {
            System.out.println(name + " : " + i);
        }
    }

    //同步代码块
    private static void method2() {
        synchronized (SynchronizedDemo.class) {
            String name = Thread.currentThread().getName();
            for (int i = 0; i < 5; i++) {
                System.out.println(name + " : " + i);
            }
        }
    }
}
