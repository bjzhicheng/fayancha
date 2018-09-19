package org.OSS;

import org.apache.log4j.PropertyConfigurator;

/**
 * @Author: yanshilong
 * @Date: 18-9-14 上午12:19
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        PropertyConfigurator.configure("/home/syl/project/Law/src/main/java/org/log4j.properties");
        picOSS pp=new picOSS();
        try {
            String aa=pp.picOSS("/home/syl/图片/2018-07-19 17-36-46 的屏幕截图.png");
            System.out.println("1234567890");
            System.out.println(aa);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
