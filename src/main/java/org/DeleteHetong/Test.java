package org.DeleteHetong;

import org.apache.log4j.PropertyConfigurator;

/**
 * @Author: yanshilong
 * @Date: 18-8-21 下午3:56
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        PropertyConfigurator.configure("/home/syl/Law/src/main/java/org/log4j.properties");
        DeleteDao dao=new DeleteDao();
        dao.setHetongid("3_htttp://8080//hhh");
        DeleteHetong deleteHetong=new DeleteHetong();
        int ii=deleteHetong.delete(dao);
        System.out.println("state = "+ii);
    }
}
