package io.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileInputStreamDemo {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream("file_os.txt");

        //一次读一个字节的数据
        /*int by = inputStream.read();
        while (by != -1) {
            System.out.println((char) by);
            by = inputStream.read();
        }*/

        //改进版代码
        int by = 0;
        while ((by = inputStream.read()) != -1) {
            System.out.println((char) by);
        }


        inputStream.close();
    }
}
