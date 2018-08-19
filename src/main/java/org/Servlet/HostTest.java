package org.Servlet;

import com.google.gson.Gson;
import org.Login.User;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Author: yanshilong
 * @Date: 18-8-14 上午10:25
 * @Version 1.0
 */
public class HostTest {
    public static String  postTest(String  strURL ) throws IOException {
        Logger logger=Logger.getLogger(HostTest.class);

        try {
            URL url=new URL(strURL);
            System.out.println(strURL);

            HttpURLConnection connection=(HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setUseCaches(true);
            connection.setInstanceFollowRedirects(true);
            connection.setRequestMethod("POST");//设置请求的方式
            connection.setRequestProperty("Accept","application/json");//设置接受数据的格式
            connection.setRequestProperty("Content-Type","application/json");//设置发送数据的格式
            connection.connect();
            OutputStreamWriter out=new OutputStreamWriter(connection.getOutputStream(),"UTF-8");
            System.out.println(out);
            out.append(new Gson().toJson(new User(111)));
            out.flush();
            out.close();



            //读取响应数据

            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String rusult=null;
            System.out.println("正在等待恢复");
            while((rusult=bufferedReader.readLine())!=null){
                System.out.println("正在读取服务端的数据");
                System.out.println(rusult);
            }


        } catch (MalformedURLException e) {
            logger.debug("this is creating a URL"+e);
        }


        String aa="error";
        return  aa;
    }
    public static void main(String[] args) throws IOException {
        postTest("http://127.0.0.1:8806/Login/Login1/Login");
      //  postTest("http://www.baidu.com");
        System.out.println("11111111");
    }
}
