package wangluo.p_04;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * UDP协议接收数据
 * Created by MIN.WU.JUN on 2020/1/7
 */
public class ReceiveDemo {

    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(12345);

        while (true) {
            byte[] bys = new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(bys, bys.length);

            socket.receive(datagramPacket);

            System.out.println("发送端：" + datagramPacket.getAddress().getHostName() + " " + datagramPacket.getAddress().getHostAddress());

            String s = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
            System.out.println(s);
        }

        //接收端其实应该一直开着
//        socket.close();
    }

}
