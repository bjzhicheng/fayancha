package org.Risk;

import org.Control.Addhetong;
import org.DaoTest.AddHetong.HetongDao;
import org.Util.State;

import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 * @Author: yanshilong
 * @Date: 18-9-22 上午1:46
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        UserDao userDao= RiskReview.riskReview("萨大王的阿中介大的阿的的阿的,四大的房屋大卫大43545,地方价4354355元,的发送买卖协议的三分大赛不一致阿四大,sdsd过户sdada房产asdasdsad交付asdasd",ContractType.SecondHandHousingSales,Party.A);
//
        ArrayList risks = userDao.getRiskList();
        ArrayList suggestions = userDao.getSuggestionList();
        int shencha1=userDao.getShencha();
        int pizhu1=userDao.getPizhu();
        int zengjia1=userDao.getIncrease();


        HetongDao hetongDao=new HetongDao();
        hetongDao.setJianyi(String.valueOf(suggestions));
        hetongDao.setFengxian(String.valueOf(risks));
        hetongDao.setUserid(1234567);
        //hetongDao.set

        System.out.println("这是我的合同---"+String.valueOf(hetongDao));
       // String aa=new String(Charset.forName("utf-8"));
        Addhetong addhetong=new Addhetong();
        State state=addhetong.addhetong(hetongDao);


        System.out.println("收藏结果：+++"+state.getState());


        System.out.println("审查条款   "+shencha1+"  批注修改      "+pizhu1+"  -----"+"增加条款： "+zengjia1);

        for (Object risk : risks) {
            System.out.println("风险是： "+risk);
        }
        for (Object suggestion : suggestions) {
            System.out.println("建议是： "+suggestion);
        }
        System.out.println(userDao.getText());

//        Pattern pattern = Pattern.compile(".*中介.*房屋.*价.*元.*买卖协议.*不一致.*");
//        Matcher matcher = pattern.matcher("萨大王的阿中介大的阿的的阿的,四大的房屋大卫大43545,地方价4354355元,的发送买卖协议的三分大赛不一致阿四大.\n萨大王的阿中介大的阿的的阿的,四大的房屋大卫大43545,地方价4354355元,的发送买卖协议的三分大赛不一致阿四大");
//        if (matcher.find()){
//            String[] regexx = (".*中介.*房屋.*价.*元.*买卖协议.*不一致.*").split("[.][*]");
//            pattern = Pattern.compile("[^.，。,]*"+regexx[regexx.length-1]+"[^.，。,]*");
////            System.out.println("[^.，。,]*"+regexx[regexx.length-1]+"[^.，。,]*");
//            matcher = pattern.matcher("萨大王的阿中介大的阿的的阿的,四大的房屋大卫大43545,地方价4354355元,的发送买卖协议的三分大赛不一致阿四大.\n萨大王的阿中介大的阿的的阿的,四大的房屋大卫大43545,地方价4354355元,的发送买卖协议的三分大赛不一致阿四大");
//            if (matcher.find()){
//                System.out.println(matcher.group());
//                System.out.println();
//                String newText = matcher.replaceAll(matcher.group()+"hello");
//                System.out.println(newText);
//                System.out.println();
//                System.out.println("萨大王的阿中介大的阿的的阿的,四大的房屋大卫大43545,地方价4354355元,的发送买卖协议的三分大赛不一致阿四大.\n萨大王的阿中介大的阿的的阿的,四大的房屋大卫大43545,地方价4354355元,的发送买卖协议的三分大赛不一致阿四大");
//            }
//        }
    }
}