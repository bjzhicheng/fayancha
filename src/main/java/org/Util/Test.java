package org.Util;

import com.aliyuncs.exceptions.ClientException;

/**
 * @Author: yanshilong
 * @Date: 18-8-31 上午12:06
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        Send smsDemo=new Send();

        String phone="18089218760";
        int response=0;
        try {
            response = smsDemo.sendSms(phone);
            System.out.println("验证码是："+response);
        } catch (ClientException e) {
            e.printStackTrace();
        }
       // SendSmsResponse response = sendSms(user);


//        GetTime getTime=new GetTime();
//        String aa=getTime.GetnowTime();
//        System.out.println(aa);
    }
    }

