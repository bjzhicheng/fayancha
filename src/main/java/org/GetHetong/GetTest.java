package org.GetHetong;

import org.apache.log4j.PropertyConfigurator;

/**
 * @Author: yanshilong
 * @Date: 18-8-21 下午2:30
 * @Version 1.0
 */
public class GetTest {
    public static void main(String[] args) {
        PropertyConfigurator.configure("/home/syl/Law/src/main/java/org/log4j.properties");
        GetDao gg=new GetDao();
        gg.setUserid(4);
        gg.setHetongid("2_htttp://8080//hhh");
        GetHetong getHetong=new GetHetong();
       String e= getHetong.get(gg);
        System.out.println(e);
    }
}
