package org.FindType;

import org.Util.State;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: yanshilong
 * @Date: 18-9-6 下午11:03
 * @Version 1.0
 */
public class Find {


    public static FanDao FindJiekuan(UserDao userDao) {
        int i = 0;
       FanDao fanhuizhi=new FanDao();
       fanhuizhi.setState(0);
        String text = userDao.getMeaaage();
        ArrayList<String> arrayList = new ArrayList();
        arrayList.add("借款");
        arrayList.add("合同");
        arrayList.add("利息");
        arrayList.add("期限");
        arrayList.add("担保");
        arrayList.add("协议");
        arrayList.add("还款");
        arrayList.add("违约金");
        arrayList.add("抵押");
        arrayList.add("保证");
        arrayList.add("贷款");
        for (int ii = 0; ii <= 10; ii++) {
            Pattern pattern = Pattern.compile((String) arrayList.get(ii));
            //System.out.println("这次在匹配关键词  "+(String)arrayList.get(ii));
            Matcher matcher = pattern.matcher(text);
            if (matcher.find()) {
                i = i + 1;
                System.out.println("匹配到关键词第 "+i+"个 " + arrayList.get(ii));

            }
        }


            if (i > 4) {
            fanhuizhi.setState(1);
            fanhuizhi.setType("借款合同");
            fanhuizhi.setOne("借款方");
            fanhuizhi.setAnother("贷款方");
                System.out.println("匹配到关键词个数为："+i);
                return fanhuizhi;
            } else  return fanhuizhi;
        }


}