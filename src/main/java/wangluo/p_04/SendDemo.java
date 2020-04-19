package wangluo.p_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP协议发送数据
 * Created by MIN.WU.JUN on 2020/1/7
 */
public class SendDemo {

    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();

        //键盘录入数据（注意，要自己控制什么时候结束）
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            byte[] bytes = line.getBytes();
            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("minwujun"), 12345);
            socket.send(datagramPacket);
            if (line.equals("886")) {
                break;
            }
        }
        socket.close();
    }

}
