package org.Servlet;

import com.google.gson.Gson;
import org.Login.Login1;
import org.Login.User;

import javax.json.Json;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author: yanshilong
 * @Date: 18-8-12 上午10:30
 * @Version 1.0
 */

    public class MainServlet {
        public static String doserver(String url,String json) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
           String response="这是 resopnse";
            String[] result=url.split("/");
            Class cla=null;
            Gson js=new Gson();//google Json转换包，方便对JSON进行序列化和反序列化
            Constructor con=null;
            //Constructor构造qi,重要的作用是用来构造实例。
            int state;
            System.out.println("请求的请求包名是： "+result[1]+"请求的类名是： "+result[2]+"请求的方法名 "+result[3]);
            State s=new State();
            switch(result[2]){
                case "Login1":
                    try {
                        cla=Class.forName(result[1]+"."+result[2]);
                        con=cla.getConstructor();
                        Login1 login1=(Login1) con.newInstance();
                        Method login=cla.getMethod(result[3],User.class);
                        state= (int) login.invoke(login1,new Gson().fromJson(json,User.class));
                        s.setState(state);
                        response=js.toJson(s);
                        return response;


                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
            }


            return response;
        }
        public static void main(String[] args) {
            Login1 login1=new Login1();
            Gson gson=new Gson();
            System.out.println(gson.toJson(login1));

            User user=new User();

            System.out.println(gson.toJson(user));

        }
    }


