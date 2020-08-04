package io;

import java.io.Serializable;

public class Dog implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private int age;
    private transient String type; // 加上了transient关键字则不会被序列化

    public Dog() {
    }

    public Dog(String name, int age) {
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

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
