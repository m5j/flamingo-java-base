package duoXianCheng._1_base.a;

/**
 * 开启线程的第2种方式
 * 笔记.md-实现Runnable接口 2-实现run方法 3-寄生于Thread中，利用Thread的start方法启动线程
 */
public class RunnableDemo {

    private static class MyThread implements Runnable {
        @Override
        public void run() {
            System.out.println("子线程-" + Thread.currentThread().getName());
        }
    }                                                                                        


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new MyThread()).start();
        }
        System.out.println("主线程结束");
    }
}
