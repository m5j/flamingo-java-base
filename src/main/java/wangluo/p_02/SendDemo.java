package wangluo.p_02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP协议发送数据
 * <p>
 * 1.创建发送端Socket对象
 * 2.创建数据，并把数据打包
 * 3.调用Socket对象的发送方法发送数据包
 * 4.释放资源
 * Created by MIN.WU.JUN on 2020/1/7
 */
public class SendDemo {

    public static void main(String[] args) throws IOException {
        //1创建发送端Socket对象
        DatagramSocket socket = new DatagramSocket();

        //2创建数据，并把数据打包
        byte[] bys = "hello 网络编程".getBytes();
        int length = bys.length;
        InetAddress address = InetAddress.getByName("minwujun");
        int port = 10086;
        DatagramPacket datagramPacket = new DatagramPacket(bys, length, address, port);

        //3调用Socket对象的发送方法发送数据包
        socket.send(datagramPacket);

        //4释放资源
        socket.close();

        System.out.println("=");
    }

}
