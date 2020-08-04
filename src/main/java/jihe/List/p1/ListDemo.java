package jihe.List.p1;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * list接口的特有功能
 */
public class ListDemo {

    public static void main(String[] args) {
        List list = new ArrayList();

        list.add("1");
        list.add("2");
        list.add("3");
        System.out.println(list);

        list.add(1, "abc"); //指定位置添加
        System.out.println(list);

        list.remove(1); //指定位置移除
        System.out.println(list);

        //List特有的迭代器
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (listIterator.next().equals("2")){
                listIterator.add("aaa");
            }
        }

        System.out.println(list);


    }
}
