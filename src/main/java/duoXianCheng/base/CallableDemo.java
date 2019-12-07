package duoXianCheng.base;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableDemo {

    private static class MyThread implements Callable<String> {

        @Override
        public String call() throws InterruptedException {
            System.out.println("子线程正在执行复杂计算...");
            Thread.sleep(2000);
            System.out.println("子线程计算完成...");
            return "孙悟空";
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(new MyThread());
        new Thread(futureTask).start();

        System.out.println("主线程执行业务逻辑");
        Thread.sleep(5000);
        System.out.println("主线程执行业务逻辑执行完毕，准备利用子线程的返回值");
        System.out.println("子线程的返回值是：" + futureTask.get());
        System.out.println("主线程执行完毕");
    }
}
