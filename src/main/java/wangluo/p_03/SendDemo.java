package wangluo.p_03;

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
        DatagramSocket socket = new DatagramSocket();
        byte[] bys = "hello 网络编程优化版".getBytes();
        DatagramPacket datagramPacket = new DatagramPacket(bys, bys.length, InetAddress.getByName("minwujun"), 12345);
        socket.send(datagramPacket);
        socket.close();
    }

}
