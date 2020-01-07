package wangluo.p_02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP协议接收数据
 * <p>
 * 1.创建接收端Socket对象
 * 2.创建一个数据包（接收容器）
 * 3.调用Socket对象的接收方法接收数据包
 * 4.解析数据包，并显示在控制台
 * 5.释放资源
 * Created by MIN.WU.JUN on 2020/1/7
 */
public class ReceiveDemo {

    public static void main(String[] args) throws IOException {
        //1创建接收端Socket对象，要指定端口
        DatagramSocket socket = new DatagramSocket(10086);

        //2创建一个数据包（接收容器）
        byte[] bys = new byte[1024];
        int length = bys.length;
        DatagramPacket datagramPacket = new DatagramPacket(bys, length);

        //3调用Socket对象的接收方法接收数据包
        socket.receive(datagramPacket); //阻塞式方法！！！ 一直等着发送端的数据

        //4解析数据包，并显示在控制台
        InetAddress address = datagramPacket.getAddress();
        System.out.println("发送端：" + address.getHostName() + " " + address.getHostAddress());

        byte[] data = datagramPacket.getData(); //获取数据缓冲区
        int length1 = datagramPacket.getLength(); //获取数据的实际长度
        String s = new String(data, 0, length1);
        System.out.println(s);

        //5释放资源
        socket.close();

        System.out.println("=");
    }

}
