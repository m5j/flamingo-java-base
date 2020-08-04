package jihe.collection.p1;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Collection接口的一些简单方法
 */
public class CollectionDemo {

    public static void main(String[] args) {
        Collection c = new ArrayList();
        System.out.println(c);

        c.add("111");
        c.add("222");
        System.out.println(c);

        /*c.clear();
        System.out.println(c);*/

        c.remove("111");
        System.out.println(c);


        System.out.println("c.contains(\"222\"):" + c.contains("222"));

        System.out.println("c.size():" + c.size());


    }
}
