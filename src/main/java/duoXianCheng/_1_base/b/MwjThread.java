package duoXianCheng._1_base.b;

/**
 * Created by minwujun on 2020/9/17
 */
public class MwjThread extends Thread {

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 10; i++) {
            System.out.println("子线程运行第" + i + "次");
        }
    }

    public static void main(String[] args) {
        MwjThread mwjThread = new MwjThread();
        mwjThread.start();

        System.out.println("主线程：我应该不是最后一行吧（说明主子线程是同时运行的）");

    }

}
