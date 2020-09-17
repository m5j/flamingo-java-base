package duoXianCheng._1_base.b;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Created by minwujun on 2020/9/17
 */
public class MwjCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        for (int i = 0; i < 10; i++) {
            System.out.println("子线程运行第" + i + "次");
        }
        return "天王盖地虎";
    }

    public static void main(String[] args) throws Exception {
        MwjCallable mwjCallable = new MwjCallable();
        mwjCallable.call();
        System.out.println("主线程：我肯定是最后运行。（当直接调用call方法时是普通方法）");

        System.out.println("------------------------");

        FutureTask futureTask = new FutureTask(mwjCallable);
        new Thread(futureTask).start();
        System.out.println("主线程：我应该不是最后一行吧（说明主子线程是同时运行的）");
        System.out.println("主线程：而且我还能拿到子线程的返回值。----" + futureTask.get()
                + "。但是必须等子线程执行完了之后我能执行，因为futureTask.get()是阻塞的");
    }
}
