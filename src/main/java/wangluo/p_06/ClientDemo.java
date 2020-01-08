package wangluo.p_06;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * TCP协议发送数据
 * 1.创建发送端的Socket对象（如果这一步成功，说明连接已经成功建立了）
 * 2.获取输出流，写数据
 * 3.释放资源
 * Created by MIN.WU.JUN on 2020/1/8
 */
public class ClientDemo {

    public static void main(String[] args) throws IOException {
        //1.创建发送端的Socket对象
//        Socket socket = new Socket(InetAddress.getByName("minwujun"), 9999);
        Socket socket = new Socket("172.16.72.63", 9999);

        //2.获取输出流，写数据
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello TCP我来了".getBytes());

        //3.释放资源
        socket.close();
    }
}
