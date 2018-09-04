package org.GetVideos;

import org.Control.Getvideos;
import org.apache.log4j.PropertyConfigurator;

/**
 * @Author: yanshilong
 * @Date: 18-9-2 下午10:03
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        PropertyConfigurator.configure("/home/syl/project/Law/src/main/java/org/log4j.properties");
        Getvideos getvideos=new Getvideos();
        String json=getvideos.GetAllVideos();
        System.out.println(json);
    }
}
