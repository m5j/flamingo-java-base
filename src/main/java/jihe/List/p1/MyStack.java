package jihe.List.p1;


import java.util.LinkedList;

/**
 * 用LinkedList做一个栈结构
 */
public class MyStack {

    private LinkedList linkedList;

    public MyStack() {
        linkedList = new LinkedList();
    }

    public void add(Object object) {
        linkedList.addFirst(object);
    }

    public Object get() {
        return linkedList.removeFirst();
    }

    @Override
    public String toString() {
        return linkedList.toString();
    }

    public int size() {
        return linkedList.size();
    }

    public boolean isEmpty() {
        return linkedList.isEmpty();
    }


    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.add("1");
        stack.add("2");
        stack.add("3");
        System.out.println(stack);

        //这样遍历是有问题的，因为stack.size()每一次元素出栈后都在变化
        /*for (int i = 0; i < stack.size(); i++) {
            System.out.println("i=" + i);
            System.out.println(stack.get());
        }*/

        while (!stack.isEmpty()) {
            System.out.println(stack.get());
        }

        System.out.println(stack);

    }
}
