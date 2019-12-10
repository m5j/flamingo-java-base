package duoXianCheng.util;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskDemo {

    private static class MyThread implements Callable<Integer> {

        private int sum;

        @Override
        public Integer call() throws Exception {
            System.out.println("子线程开始计算");
            Thread.sleep(2000);
            for (int i = 0; i < 5000; i++) {
                sum = sum + i;
            }
            System.out.println("子线程计算完成，结果=" + sum);
            return sum;
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        MyThread myThread = new MyThread();
        FutureTask<Integer> futureTask = new FutureTask<>(myThread);
        new Thread(futureTask).start();

        Thread.sleep(1000);

        Random random = new Random();
        if (random.nextBoolean()) {
            System.out.println("得到子线程计算结果=" + futureTask.get());
        }else {
            System.out.println("中断计算");
            boolean cancel = futureTask.cancel(true);
            System.out.println(cancel);
        }
    }
}
