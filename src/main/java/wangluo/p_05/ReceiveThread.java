package wangluo.p_05;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Created by MIN.WU.JUN on 2020/1/8
 */
public class ReceiveThread implements Runnable {
    private DatagramSocket ds;

    public ReceiveThread(DatagramSocket ds) {
        this.ds = ds;
    }

    @Override
    public void run() {
        byte[] bys = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bys, bys.length);

        while (true){
            try {
                ds.receive(dp);
            } catch (IOException e) {
                e.printStackTrace();
            }
            byte[] data = dp.getData();
            String s = new String(data, 0, data.length);
            System.out.println("from " + dp.getAddress().getHostAddress() + " : " + s);
        }

    }
}
