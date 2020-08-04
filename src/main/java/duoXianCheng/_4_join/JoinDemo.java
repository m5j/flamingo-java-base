package duoXianCheng._4_join;

public class JoinDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread previous = Thread.currentThread(); //第一次是主线程

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new JumpQueue(previous), String.valueOf(i));
            System.out.println(previous.getName() + " 插到了这个线程的前面： " + thread.getName());
            thread.start();
            previous = thread;
        }

        Thread.sleep(2000); //让主线程休眠2秒
        System.out.println("主线程执行完毕");

    }


    static class JumpQueue implements Runnable {
        private Thread thread; //插队的线程

        public JumpQueue(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + " 执行完了");
        }
    }
}
