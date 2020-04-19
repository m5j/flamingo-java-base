package jihe.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsDemo {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(4);
        list.add(5);
        System.out.println(list);

        Collections.sort(list); //自然顺序升序
        System.out.println(list);

        int i = Collections.binarySearch(list, 2); //二分查找
        System.out.println(i);

        Comparable max = Collections.max(list); //找最大值
        System.out.println(max);

        Collections.reverse(list); //反转
        System.out.println(list);

        Collections.shuffle(list); //随机置换
        System.out.println(list);

    }
}
