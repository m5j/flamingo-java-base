package duoXianCheng.cas;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 引用类型原子类
 */
public class AtomicReferenceDemo {

    static AtomicReference<UserInfo> userInfoAtomicReference = new AtomicReference<>();

    static class UserInfo {
        private String name;
        private int age;

        public UserInfo() {
        }

        public UserInfo(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }


    public static void main(String[] args) {
        UserInfo userInfo1 = new UserInfo("Mark", 11);
        userInfoAtomicReference.set(userInfo1);

        UserInfo userInfo2 = new UserInfo("Mark", 15);
        userInfoAtomicReference.compareAndSet(userInfo1, userInfo2);

        System.out.println(userInfo1.getAge());//可以发现，userInfo1的值并未被单独改变
        System.out.println(userInfoAtomicReference.get().getAge());//改变的是整个引用对象（更换了一个引用对象）
    }
}
