package stream._0_;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by minwujun on 2020/4/14
 */
public class Demo {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(4);
        list.add(2);
        list.add(3);
        list.add(14);
        list.add(63);
        Stream<Integer> stream = list.stream();
        stream.forEach(System.out::println);
//        IntStream.rangeClosed(1, 3).forEach(System.out::println);
    }


}
