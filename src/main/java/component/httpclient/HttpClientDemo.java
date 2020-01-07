package component.httpclient;


import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by MIN.WU.JUN on 2020/1/6
 */
public class HttpClientDemo {
    public static void main(String[] args) {
        //创建客户端
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        //构造请求
        HttpGet httpGet = new HttpGet("https://blog.csdn.net/justry_deng/article/details/81042379");
        CloseableHttpResponse response = null;
        try {
            //用客户端发送请求，获得响应
            response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            System.out.println("响应状态为：" + response.getStatusLine());
            if (entity != null) {
                System.out.println("响应内容长度为:" + entity.getContentLength());
                System.out.println("响应内容为:" + EntityUtils.toString(entity));
            }
        } catch (Exception ignored) {

        } finally {
            try {
                if (httpClient != null) {
                    httpClient.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
