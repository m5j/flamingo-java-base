package wangluo.p_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by MIN.WU.JUN on 2020/1/8
 */
public class SendThread implements Runnable {

    private DatagramSocket ds;

    public SendThread(DatagramSocket ds) {
        this.ds = ds;
    }

    @Override
    public void run() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                byte[] bytes = line.getBytes();
                DatagramPacket dp = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("minwujun"), 12306);
                ds.send(dp);
            }
            ds.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
