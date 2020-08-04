package io.io;

import java.io.*;

public class BufferedIoDemo {
    public static void main(String[] args) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\Users\\minwujun\\Pictures\\微信公众号素材\\TIM截图20190529225345.png"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("11"));

        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = bis.read(bytes)) != -1) {
            bos.write(bytes, 0, len);
        }


        bis.close();
        bos.close();

    }
}
