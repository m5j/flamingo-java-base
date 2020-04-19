package duoXianCheng._2_threadlocal;


public class ThreadLocalDemo {

    private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 1);


    public static void main(String[] args) {
        startNThread(5);
    }

    /**
     * 开启多个线程
     */
    public static void startNThread(int size) {
        Thread[] threadArray = new Thread[size];
        for (int i = 0; i < threadArray.length; i++) {
            threadArray[i] = new Thread(new MyThread(i));
        }
        for (Thread thread : threadArray) {
            thread.start();
        }

    }

    /**
     * 自定义的线程
     */
    public static class MyThread implements Runnable {
        int id;

        public MyThread(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " : start");
            Integer integer = threadLocal.get();
            threadLocal.set(integer + id); //重复赋值
            System.out.println(Thread.currentThread().getName() + " : " + threadLocal.get());
        }
    }
}
