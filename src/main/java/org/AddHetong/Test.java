package org.AddHetong;

import org.AddHetong.Addhetong;
import org.AddHetong.HetongDao;
import org.apache.log4j.PropertyConfigurator;

/**
 * @Author: yanshilong
 * @Date: 18-8-21 下午1:46
 * @Version 1.0
 *
 *
 * 内存管理
 * gc结构
 * gc youhua
 *
 */
public class Test {
    public static void main(String[] args) {
        PropertyConfigurator.configure("/home/syl/Law/src/main/java/org/log4j.properties");

        HetongDao hhh = new HetongDao();
        hhh.setId("34");
        hhh.setLoves(0);
        hhh.setTitle("xinwenhah12hah");
        hhh.setUrl("htttp://4132//hhh/fo");
        Addhetong addhetong=new Addhetong();
        addhetong.addhetong(hhh);
    }
}
