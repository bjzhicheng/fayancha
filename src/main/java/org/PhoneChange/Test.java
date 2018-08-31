package org.PhoneChange;

import org.apache.log4j.PropertyConfigurator;

/**
 * @Author: yanshilong
 * @Date: 18-8-21 下午5:49
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        PropertyConfigurator.configure("/home/syl/Law/src/main/java/org/log4j.properties");
        PhoneDao user=new PhoneDao();
        user.setId(2);
        PhoneChange getnumber=new PhoneChange();
        getnumber.getphone(user);
    }
}
