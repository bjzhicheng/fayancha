package org.ShenHe;

import org.Util.State;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: yanshilong
 * @Date: 18-9-19 下午11:45
 * @Version 1.0
 */
public class Task1 implements Callable<State> {
    UserDao userDao=null;
    Task1(UserDao userDao){
       this.userDao=userDao;
   }

    @Override
    public State call() throws Exception {
        State  state=new State();

//        System.out.println("这是TASK1---");
//       userDao.setState(1);
//       userDao.setType("离婚合同");
        int i = 0;

        userDao.setState(0);
        String text = userDao.getMessage();
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




            Matcher matcher = pattern.matcher(text);

            if (matcher.find()) {
                i = i + 1;
                System.out.println("匹配到关键词第 "+i+"个 " + arrayList.get(ii));

            }
        }


        if (i > 4) {

            userDao.setState(1);
//            userDao.setType("借款合同");
//            userDao.setOne("借款方");
//            userDao.setAnother("贷款方");
//            System.out.println("匹配到关键词个数为："+i);


        state.setId(userDao.getUserid());
       state.setMessage(text);
      state.setState(1);
      state.setOne("借款方");
      state.setAnother("贷款方");
      state.setType("借款合同");

        }



        return state;
    }
}
