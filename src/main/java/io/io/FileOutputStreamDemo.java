package io.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileOutputStreamDemo {
    public static void main(String[] args) throws IOException {
        //从头写入
        OutputStream outputStream = new FileOutputStream("file_os.txt");
        //true表示追加写入
        OutputStream os = new FileOutputStream("file_os.txt", true);

        //写数据
        outputStream.write("你好java".getBytes()); //写字节数组
        outputStream.write("\n".getBytes()); //写入换行符
        outputStream.write(" hello".getBytes(), 0, " hello".length()); //写字节数组的一部分
        outputStream.write("\t".getBytes()); //写入制表符
        outputStream.write("io流".getBytes());


        //释放资源
        outputStream.close();
    }
}
