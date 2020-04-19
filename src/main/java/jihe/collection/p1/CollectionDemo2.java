package jihe.collection.p1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Collection的迭代器遍历
 */
public class CollectionDemo2 {
    public static void main(String[] args) {
        Collection c = new ArrayList();
        c.add("1");
        c.add("2");
        c.add("3");

        Iterator iterator = c.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }
    }
}
