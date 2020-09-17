package duoXianCheng._1_base.b;

/**
 * Created by minwujun on 2020/9/17
 */
public class MwjRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("子线程运行第" + i + "次");
        }
    }

    public static void main(String[] args) {
        MwjRunnable mwjRunnable = new MwjRunnable();
        mwjRunnable.run();
        System.out.println("主线程：我肯定是最后运行。（当直接调用run方法时是普通方法）");
        System.out.println("------------------------");
        new Thread(mwjRunnable).start();
        System.out.println("主线程：我应该不是最后一行吧（说明主子线程是同时运行的）");

    }
}
