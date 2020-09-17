package duoXianCheng._1_base.a;

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
        FutureTask<String> futureTask = new FutureTask<>(new MyThread()); //用FutureTask的构造方法将其包起来
        new Thread(futureTask).start(); //用Thread的构造方法将futureTask包起来，并调用start方法启动

        System.out.println("主线程执行业务逻辑");
//        Thread.sleep(5000);
        System.out.println("主线程执行业务逻辑执行完毕，准备利用子线程的返回值");
        System.out.println("子线程的返回值是：" + futureTask.get()); //futureTask.get()是阻塞的，所以会等待子线程执行完毕，主线程才会继续执行
        System.out.println("主线程执行完毕");
    }
}
