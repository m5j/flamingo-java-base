package wangluo.p_05;

import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 使用多线程完成一个聊天室
 * Created by MIN.WU.JUN on 2020/1/8
 */
public class ChatRoom {
    public static void main(String[] args) throws SocketException {
        DatagramSocket dsSend = new DatagramSocket();
        DatagramSocket dsReceive = new DatagramSocket(12306);

        SendThread sendThread = new SendThread(dsSend);
        ReceiveThread receiveThread = new ReceiveThread(dsReceive);

        new Thread(sendThread).start();
        new Thread(receiveThread).start();
    }
}
