package wangluo.p_03;

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
        DatagramSocket socket = new DatagramSocket(12345);

        byte[] bys = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(bys, bys.length);

        socket.receive(datagramPacket);

        System.out.println("发送端：" + datagramPacket.getAddress().getHostName() + " " + datagramPacket.getAddress().getHostAddress());

        String s = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
        System.out.println(s);

        socket.close();
    }

}
