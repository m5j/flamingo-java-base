package io.io;

import io.Dog;

import java.io.*;

/**
 * 序列化流/反序列化流
 * 作用是读写对象，要求对象必须实现Serializable接口
 */
public class ObjectOutputStreamDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        write();
        read();
    }


    public static void write() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("oos.txt"));

        Dog dog = new Dog("阿黄", 2);

        oos.writeObject(dog);

        oos.close();
    }


    public static void read() throws IOException, ClassNotFoundException {
        ObjectInputStream oos = new ObjectInputStream(new FileInputStream("oos.txt"));

        Dog dog = (Dog) oos.readObject();

        System.out.println(dog);

        oos.close();
    }
}
