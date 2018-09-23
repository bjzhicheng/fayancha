package org.mysevlete;


import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;

import org.Control.*;
import org.DaoTest.AddHetong.HetongDao;
import org.DaoTest.HeTong.GetDao;
import org.DaoTest.Lawers.LawersDao;
import org.DaoTest.Login.User;
import org.DaoTest.News.NewsDao;
import org.DaoTest.PassChange.PassDao;
import org.DaoTest.PhoneChange.PhoneDao;
import org.DaoTest.Register.UserDao;
import org.GetVideos.VideosDao;
import org.Pay.PayUser;
import org.Util.Message;
import org.Util.State;
import org.apache.log4j.Logger;

import org.apache.log4j.PropertyConfigurator;
;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author: yanshilong
 * @Date: 18-8-31 下午2:43
 * @Version 1.0
 */

public class ServletTest {
    public static void main(String[] args) {
        PropertyConfigurator.configure("/home/syl/Law/src/main/java/org/log4j.properties");

    }
    public static  State doServlet(Message message) {
        Logger LOGGER=Logger.getLogger(Message.class);
        String url = message.getUrl();
        LOGGER.info("this is message get url"+url);
            String gson = message.getData();
            String response = "{\"state\":0}";
            State state = new State();
            String[] result = url.split("/");
            Class cls = null;
            Gson g = new Gson();
            Constructor con = null;

//
        try {

            LOGGER.info("请求的资源： Control."+result[1]+result[2]);
            //result[1]=============类名
            //result[2]==============方法名

                 //1登陆=========================================================================================================
            switch (result[1]){
                case "Login1":
                    cls=Class.forName("org.Control."+result[1]);

                    con=cls.getConstructor();
                    Login1 login1=(Login1) con.newInstance();
                        Method dologin=cls.getMethod(result[2],User.class);
                        state= (State) dologin.invoke(login1,new Gson().fromJson(gson,User.class));
//                    state.setState(state1);
                    return state;


                    //2注册======================================================================================================
                case "Register1":
                    cls=Class.forName("org.Control."+result[1]);
                    con=cls.getConstructor();
                    Register1 register1=(Register1) con.newInstance();
                    Method doregister=cls.getMethod(result[2],UserDao.class);
//                    if (result[2].equals("Getmessage")){
//
//
//                    }else if (result[2].equals("Regesit")){}
                    state= (State) doregister.invoke(register1,new Gson().fromJson(gson,UserDao.class));

                    return state;


                    //3手机号变更=====================================================================================================
                case "PhoneChange":
                    cls=Class.forName("org.Control."+result[1]);
                    con=cls.getConstructor();
                    PhoneChange phoneChange1= (PhoneChange) con.newInstance();
                    Method dophonechange=cls.getMethod(result[2],PhoneDao.class);
                    state= (State) dophonechange.invoke(phoneChange1,new Gson().fromJson(gson,PhoneDao.class));

                    return state;


                    //4收藏合同==========================================================================================
                case "Addhetong":
                    cls=Class.forName("org.Control."+result[1]);
                    con=cls.getConstructor();
                    Addhetong addhetong1= (Addhetong) con.newInstance();
                    Method doaddhetong=cls.getMethod(result[2],HetongDao.class);
                    state= (State) doaddhetong.invoke(addhetong1,new Gson().fromJson(gson,HetongDao.class));

                    return state;

                    //5查看收藏合同=====================================================================================

                case "GetHetong":
                    cls=Class.forName("org.Control."+result[1]);
                    con=cls.getConstructor();
                    GetHetong gethetong= (GetHetong) con.newInstance();
                    Method dogethetong=cls.getMethod(result[2],GetDao.class);
                    state= (State) dogethetong.invoke(gethetong,new Gson().fromJson(gson,GetDao.class));
                    return state;



//                    Gson json= (Gson) dogethetong.invoke(gethetong,new Gson().fromJson(gson,GetDao.class));
//
//                    return json;





                    //6查找律师===========================================================================================

                case "GetLawers":
                    cls=Class.forName("org.Control."+result[1]);
                    con=cls.getConstructor();
                    GetLawers getLawers= (GetLawers) con.newInstance();
                    Method dogetlawers=cls.getMethod(result[2],LawersDao.class);
                    state=(State)dogetlawers.invoke(getLawers,new Gson().fromJson(gson,LawersDao.class));
                    return state;


                    //7获取新闻=========================================================================================
                case  "GetNews":
                    cls=Class.forName("org.Control."+result[1]);
                    con=cls.getConstructor();
                    GetNews getNews= (GetNews) con.newInstance();
                    Method dogetnews=cls.getMethod(result[2],NewsDao.class);
                    state= (State) dogetnews.invoke(getNews,new Gson().fromJson(gson,NewsDao.class));
                    return state;

                    //8查看优惠券==========================================================================================
                case "Getvoucher":
                    cls=Class.forName("org.Control."+result[1]);
                    con=cls.getConstructor();
                    Getvoucher getvoucher= (Getvoucher) con.newInstance();
                    Method dpoget=cls.getMethod(result[2], org.Pay.User.class);
                    state= (State) dpoget.invoke(getvoucher,new Gson().fromJson(gson, org.Pay.User.class));
                    return state;

                    //9 余额支付========================================================================================
                case "Pay":
                     cls=Class.forName("org.Control."+result[1]);
                     con=cls.getConstructor();
                     Pay pay= (Pay) con.newInstance();
                     Method dopay=cls.getMethod(result[2],PayUser.class);
                     state= (State) dopay.invoke(pay,new Gson().fromJson(gson,PayUser.class));
                     return state;


                     //10 优惠券支付=======================================================================================
                case "UuiPay":
                      cls=Class.forName("org.Control."+result[1]);
                      con=cls.getConstructor();
                      UuiPay upay= (UuiPay) con.newInstance();
                      Method doupay=cls.getMethod(result[2],PayUser.class);
                      state= (State) doupay.invoke(upay,new Gson().fromJson(gson, PayUser.class));
                      return state;

                      //11 用户基本信息修改============================================
                case "Userchange":
                    cls=Class.forName("org.Control."+result[1]);
                    con=cls.getConstructor();
                    Userchange userchange= (Userchange) con.newInstance();
                    Method douserchange=cls.getMethod(result[2], org.DaoTest.Userchange.UserDao.class);
                    state= (State) douserchange.invoke(userchange,new Gson().fromJson(gson, org.DaoTest.Userchange.UserDao.class));

                            return state;


                   //12 修改密码===========================================================================================
                case "PassChangeSend":
                    cls=Class.forName("org.Control."+result[1]);
                    con=cls.getConstructor();
                    PassChangeSend passChange= (PassChangeSend) con.newInstance();
                     Method  dopasschange=cls.getMethod(result[2],PassDao.class);
                     state= (State) dopasschange.invoke(passChange,new Gson().fromJson(gson,PassDao.class));
                     return state;

                      // 13 查看个人信息===================================================



                case "GetInformation":



                        cls=Class.forName("org.Control."+result[1]);
                        con=cls.getConstructor();
                        GetInformation getinfomation= (GetInformation) con.newInstance();
                        Method dogetmation=cls.getMethod(result[2], org.DaoTest.Userchange.UserDao.class);
                        state= (State) dogetmation.invoke(getinfomation,new Gson().fromJson(gson, org.DaoTest.Userchange.UserDao.class));

                        return state;

                  //获取videos
                case "Getvideos":
                      cls=Class.forName("org.Control."+result[1]);
                      con=cls.getConstructor();
                      Getvideos getvideos= (Getvideos) con.newInstance();
                      Method  dogetvideos=cls.getMethod(result[2],VideosDao.class);
                      state= (State) dogetvideos.invoke(getvideos,new Gson().fromJson(gson,VideosDao.class));


                   return state;
            }





        } catch (ClassNotFoundException e) {
            LOGGER.warn("this is a warn when class from: "+e);
        } catch (NoSuchMethodException e) {
            LOGGER.warn("this is in create construct "+e);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
//        try {
////            cls = Class.forName("control."+result[1]);
////            Constructor con=cls.getConstructor();
//            System.out.println(result[1]+"----"+result[2]);
//            switch (result[1]){
//                case "Store":
//                    cls = Class.forName("control."+result[1]);
//                    con=cls.getConstructor();
//                    Store store= (Store) con.newInstance();
//                    Method doStore=cls.getMethod(result[2], Goods.class);
//                    status= (State) doStore.invoke(store,new
//                            Gson().fromJson(gson,Goods.class));
//                    response=g.toJson(status);


    return state;
    }

}
//        int state;
//        State s=new State();

//            cls = Class.forName("control."+result[1]);
//            Constructor con=cls.getConstructor();
//            System.out.println(result[1]+"----"+result[2]);
//            switch (result[1]){
//                case "Store":
//                    cls = Class.forName("control."+result[1]);
//                    con=cls.getConstructor();
//                    Store store= (Store) con.newInstance();
//                    Method doStore=cls.getMethod(result[2], Goods.class);
//                    status= (State) doStore.invoke(store,new
//                            Gson().fromJson(gson,Goods.class));
//                    response=g.toJson(status);

//                    if(result[2].equals("doStore")){
//
//                    System.out.println("");
//
//                    }else if(result[2].equals("doChange")){
//                        cls = Class.forName("control."+result[1]);
//                        con=cls.getConstructor();
//                        Store store= (Store) con.newInstance();
//                        Method doChange=cls.getMethod(result[2],Goods.class);
//                        status= (State) doChange.invoke(store,new
//                                Gson().fromJson(gson,Goods.class));
//                        response=g.toJson(status);
////                    System.out.println(doStore.invoke(store,object));
//                    }
          //          return status;





