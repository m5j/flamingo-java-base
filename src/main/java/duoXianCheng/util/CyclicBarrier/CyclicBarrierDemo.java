package duoXianCheng.util.CyclicBarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier中文翻译是【循环壁垒】
 * 对于给定的n个线程，这n个线程都执行了await方法后，才开始执行后面的逻辑，否则等待
 * 形象地解释：有一扇石门（壁垒），必须要n个人一起才能推开，所以先到的人必须得等待，一直等到人数为n。
 * 当门被推开后，石门又会关闭，等待下一批n个人来打开（循环）
 */
public class CyclicBarrierDemo {

    private static final CyclicBarrier cyclicBarrier = new CyclicBarrier(4, () -> System.out.println("回调方法已执行..."));

    private static class MyThread implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + " 进入");
                cyclicBarrier.await(); //当await的线程数量达到设定的值后，才继续往下执行
                System.out.println(Thread.currentThread().getName() + " 继续工作");
            } catch (Exception ignored) {

            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            new Thread(new MyThread()).start();
        }
    }

}
