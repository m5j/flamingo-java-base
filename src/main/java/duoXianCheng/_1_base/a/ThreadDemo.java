package duoXianCheng._1_base.a;

/**
 * 开启线程第1种方式
 * 笔记.md-继承Thread类 2-重写run方法 3-start方法开启线程
 */
public class ThreadDemo {

    private static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("子线程-" + Thread.currentThread().getName());
        }
    }


    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            new MyThread().start();
        }

        System.out.println("主线程执行完毕");

    }

}
