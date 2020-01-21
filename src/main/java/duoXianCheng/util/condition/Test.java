package duoXianCheng.util.condition;

/**
 * Created by MIN.WU.JUN on 2020/1/16
 */
public class Test {
    public static void main(String[] args) {
//        BoundedQueue<Integer> boundedQueue = new BoundedQueue<>(2);
//        boundedQueue.add(1);
//        boundedQueue.add(2);
//        boundedQueue.add(3);
        Express express = new Express(0, "SHANGHAI");
        express.waitSite();
        express.changeSite();
    }
}
