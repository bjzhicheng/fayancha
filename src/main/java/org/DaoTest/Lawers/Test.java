package org.DaoTest.Lawers;

import org.Control.GetLawers;
import org.Util.State;
import org.apache.log4j.PropertyConfigurator;

/**
 * @Author: yanshilong
 * @Date: 18-8-22 下午11:19
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        PropertyConfigurator.configure("/home/syl/project/Law/src/main/java/org/log4j.properties");
//        GetLawers getLawers=new GetLawers();
//        String aa=getLawers.GetAll();
//        System.out.println(aa);

        GetLawers getLawers=new GetLawers();
        LawersDao ll=new LawersDao();
        ll.setId(1231);
        State aa=getLawers.GetOne(ll);
        System.out.println(aa);
    }
}
