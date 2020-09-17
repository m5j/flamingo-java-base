package duoXianCheng.deadlock;

/**
 * 演示死锁：两个线程都在获取对方未释放的锁，所以两个都获取不到，程序一直卡着。你不让我也不让
 *
 * 避免死锁的几个常见方法：
 * 1.避免一个线程同时获取多个锁
 * 2.避免一个线程在锁内占用多个资源，尽量一个锁只占用一个资源
 * 3.尝试使用定时锁，使用lock.tryLock(timeout)来替代使用内置锁
 * 4.对于数据库锁，加锁和解锁必须在同一个数据库连接里，否则会出现解锁失败的情况
 */
public class DeadLockDemo {

    private static final String A = "A";
    private static final String B = "B";

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A) {
                    //休眠2秒
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (B){
                        System.out.println("线程1");
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (B) {
                    synchronized (A){
                        System.out.println("线程2");
                    }
                }
            }
        }).start();

    }
}
