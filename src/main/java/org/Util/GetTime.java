package org.Util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: yanshilong
 * @Date: 18-9-6 下午1:20
 * @Version 1.0
 */
public class GetTime {
    public static String  GetnowTime(){
        SimpleDateFormat sdf=new SimpleDateFormat("MM-dd hh:mm:ss");

        return sdf.format(new Date());
    }


}
