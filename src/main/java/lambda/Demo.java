package lambda;

/**
 * Created by minwujun on 2020/4/14
 */
public class Demo {
    public static void main(String[] args) {

        Runnable runnable = () -> {
            System.out.println("11");
        };

        Runnable runnable1 = () -> System.out.println("11");


        // 1个参数的 lambda 表达式
        OneParameter oneParameter = x -> {
            System.out.println("One Param:" + x);
        };

        // 2个参数的 lambda 表达式
        TwoParameters twoParameters = (x, y) -> {
            System.out.println("Two Param:" + x + ":" + y);
        };

        // 字符串参数的 lambda 表达式
        StringParam strParam = str -> {
            System.out.println("String Param:" + str.length());
        };

    }
}
