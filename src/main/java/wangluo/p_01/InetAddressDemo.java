package wangluo.p_01;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by MIN.WU.JUN on 2020/1/7
 */
public class InetAddressDemo {
    public static void main(String[] args) throws UnknownHostException {
//        InetAddress address = InetAddress.getByName("minwujun");
        InetAddress address = InetAddress.getByName("172.16.72.63");
        String hostName = address.getHostName();
        String hostAddress = address.getHostAddress();
        System.out.println(hostName + "---" + hostAddress);

    }
}
