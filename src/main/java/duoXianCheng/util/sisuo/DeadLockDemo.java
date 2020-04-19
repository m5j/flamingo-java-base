package duoXianCheng.util.sisuo;

/**
 * 一个死锁程序
 */
public class DeadLockDemo {

    private static final Object obj1 = new Object();
    private static final Object obj2 = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println("thread1 is running");
            synchronized (obj1) { //线程1拿到锁1
                System.out.println("thread1 is block obj1");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (obj2) { //线程1试图去拿锁2，但是拿不到
                    System.out.println("线程1拿到了锁2");
                }
            }
        }).start();

        new Thread(() -> {
            System.out.println("thread2 is running");
            synchronized (obj2) { //线程2拿到锁2
                System.out.println("thread2 is block obj2");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (obj1) { //线程2试图去拿锁1，但是拿不到
                    System.out.println("线程2拿到了锁1");
                }
            }
        }).start();
    }
}
