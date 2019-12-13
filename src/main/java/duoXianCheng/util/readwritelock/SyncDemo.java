package duoXianCheng.util.readwritelock;

/**
 * 在读写场景中使用synchronized关键字来保证同步
 * 缺点：如果都是读线程的话，读与读之间会同步等待，性能不好
 * <p>
 * 与ReadWriteLockDemo对比学习
 * Created by MIN.WU.JUN on 2019/12/13
 */
public class SyncDemo {

    private synchronized void read(Thread thread) {
        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start <= 10) {
            System.out.println(thread.getName() + "正在进行读操作");
        }
        System.out.println(thread.getName() + "读操作完毕");
    }

    public static void main(String[] args) {
        final SyncDemo test = new SyncDemo();
        new Thread(() -> test.read(Thread.currentThread())).start();
        new Thread(() -> test.read(Thread.currentThread())).start();
    }


}
