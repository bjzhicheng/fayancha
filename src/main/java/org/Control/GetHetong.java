package org.Control;

import com.alibaba.fastjson.JSON;
import org.DaoTest.AddHetong.*;
import org.DaoTest.HeTong.GetDao;
import org.Util.JDBCConnection;
import org.Util.State;
import org.apache.log4j.Logger;
import redis.clients.jedis.Jedis;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;


/**
 * @Author: yanshilong
 * @Date: 18-8-21 下午1:52
 * @Version 1.0
 * getall(GetDao getDao) 直接从mysql中搜索
 * get(GetDao getDao)从redis6381---mysql
 *
 */
public class GetHetong {
      static Logger LOGGER= Logger.getLogger(GetHetong.class);
      State state=new State();

   //==================================================================================================================
    //直接查询mysql返回url id time 所有的相关的信息
    public State getall(GetDao getDao) {
        int userid=getDao.getUserid();
        Connection connection=JDBCConnection.getconnection();
        ArrayList arrayList=new ArrayList();


        String sql="Select * from hetong where userid ="+userid;
        LOGGER.info("this is my sql"+sql);
        try {
            Statement statement=connection.createStatement();
            ResultSet rs=statement.executeQuery(sql);
            while (rs.next()){
                HetongDao rhetongDao=new HetongDao();
                rhetongDao.setId(rs.getInt("id"));
               // rhetongDao.setUrl(rs.getString("url"));
                rhetongDao.setTitle(rs.getString("title"));
                rhetongDao.setTime(rs.getString("time"));
               // rhetongDao.setMessage(rs.getString("message"));
                rhetongDao.setFengxian(rs.getString("fengxian"));
                rhetongDao.setJianyi(rs.getString("jianyi"));

                arrayList.add(rhetongDao);



            }
        } catch (SQLException e) {
            LOGGER.debug("this is in createstatement"+e);
        }
        String json=JSON.toJSONString(arrayList);
        state.setMessage(json);
        state.setState(1);
        LOGGER.info("这是我们的 "+json);
 return state;

//        public static List getBuy() {
//            String result="";
//            NewNeeds needs[]=new NewNeeds[50];
//            ArrayList<NewNeeds> list=new ArrayList<>();
//            // ArrayList<String> list=new ArrayList<>();
//            int flag=0;
//            Connection conn = getConn();//title="+"'"+title+"'"
//            String sql = "select * from newneeds where state ='买' or state ='购' limit 50;";
//            System.out.println(sql);
//            try {
//                Statement statement=conn.createStatement();
//                ResultSet rs = statement.executeQuery(sql);
//                while (rs.next()&flag<50) {
//                    NewNeeds news=new NewNeeds();
//                    //news.setTitle(title);
//                    news.setUsername(rs.getString("username"));
//                    news.setPassward(rs.getString("passward"));
//                    news.setContent(rs.getString("content"));
//
//                    list.add(news);
//
//                    needs[flag]=news;
//                    flag++;
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//    }
    }
    //=================================================================================================================
    //查看具体的信息  走 redis6381----mysql 返回id+url


    public State getOne(GetDao getDao){
        String aa=null;
        String mmess="";
        int id=getDao.getId();
        LOGGER.info("合同的id是  "+id);
//        Jedis jedis6381=new Jedis("127.0.0.1",6381);
//        Set ss=jedis6381.keys(String.valueOf(id));
//        Iterator iterator=ss.iterator();
//        while (iterator.hasNext()){
//            System.out.println("这是redis查询================");
//            aa=(String)iterator.next();
//            System.out.println("key=  "+aa);
//
//            String lli=jedis6381.get(aa);
//            mmess=JSON.toJSONString(lli);
//
//
//
//
//            System.out.println("list=  "+mmess);
//
//
//
//        }
//        if (aa!=null){//走redis
//
//            jedis6381.expire(String.valueOf(id),7*24*60*60);
//
//            state.setMessage(mmess);
//            state.setState(1);
//            LOGGER.info("this is my message from redis "+mmess);
//            jedis6381.close();
//            return state;
//        }else {


            Connection connection=JDBCConnection.getconnection();
            String sql="select * from hetong where id ="+id;
            LOGGER.info("this is my sql  "+sql);
            try {
                HetongDao hetongDao=new HetongDao();
                Statement statement=connection.createStatement();
                ArrayList list=new ArrayList();
                ResultSet resultSet=statement.executeQuery(sql);
                while (resultSet.next()){


                    hetongDao.setTitle(resultSet.getString("title"));
                    hetongDao.setTime(resultSet.getString("time"));
                    hetongDao.setJianyi(resultSet.getString("jianyi"));
                    hetongDao.setFengxian(resultSet.getString("fengxian"));

                   list.add(hetongDao);

                }
                LOGGER.info("this is message from sql "+list);

//                jedis6381.set(String.valueOf(id),String.valueOf(list));
//                jedis6381.expire(String.valueOf(id),7*24*3600);
//                jedis6381.close();


                String json=JSON.toJSONString(list);
                state.setMessage(json);
                state.setState(1);
            } catch (SQLException e) {
                LOGGER.warn("this is in create statement   "+e);
            }
            return state;

        }
//        Set ss=jedis.keys(String.valueOf(id));
//        Iterator iterator=ss.iterator();
//        while(iterator.hasNext()){
//            uid=iterator.next();
//            upass=jedis.get(String.valueOf(uid));
//            System.out.println(uid+upass+"12121212");

      //  }






    }




//}
