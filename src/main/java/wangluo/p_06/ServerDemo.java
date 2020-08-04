package wangluo.p_06;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP协议接收数据
 * 1.创建接收端的ServerSocket对象
 * 2.监听客户端
 * 3.获取输入流，读取数据显示在控制台
 * 4.释放资源（释放客户端的Socket）
 * Created by MIN.WU.JUN on 2020/1/8
 */
public class ServerDemo {
    public static void main(String[] args) throws IOException {
        //1.创建接收端的ServerSocket对象
        ServerSocket serverSocket = new ServerSocket(9999);

        //2.监听客户端，返回一个Socket对象
        Socket acceptSocket = serverSocket.accept(); //阻塞式方法。侦听并接收此套接字的连接，在连接传入之前一直阻塞

        //3.获取输入流，读取数据显示在控制台
        InputStream inputStream = acceptSocket.getInputStream();
        byte[] bytes = new byte[1024];
        int len = inputStream.read(bytes); //阻塞式方法
        String s = new String(bytes, 0, len);
        System.out.println("from " + acceptSocket.getInetAddress().getHostAddress() + " : " + s);

        OutputStream outputStream = acceptSocket.getOutputStream();
        outputStream.write("这是我的回复".getBytes());

        //4.释放资源（释放客户端的Socket）
        acceptSocket.close();
        //serverSocket.close(); //这个不应该关闭，因为服务端要一直开启服务
    }
}
