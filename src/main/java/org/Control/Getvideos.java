package org.Control;


import com.alibaba.fastjson.JSON;
import org.GetVideos.VideosDao;
import org.Util.JdbcPool;
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
 * @Date: 18-9-2 下午10:03
 * @Version 1.0
 */
public class Getvideos {
    String HOST="127.0.0.1";
    Logger LOGGER=Logger.getLogger(Getvideos.class);

    static Connection getcoon(){
        Connection coon= (Connection) JdbcPool.get();
        return coon;
    }

    public  String GetAllVideos(VideosDao video){

            ArrayList<VideosDao> arrayList=new ArrayList<>();


            String json=null;
            VideosDao videosDao=new VideosDao();
            Connection connection=null;
            connection=getcoon();
            //select * from tbl limit 100
            String sql="select * from videos limit 100 ";
            LOGGER.info("this is my sql : "+sql);
        Jedis jedis6383=new Jedis(HOST,6383);
//
            int id;
            String uu=null;
                try {
                    Statement statement=connection.createStatement();
                    ResultSet resultSet=statement.executeQuery(sql);

                    while (resultSet.next()){
                        videosDao.setId(resultSet.getInt("id"));
                        videosDao.setLoves(resultSet.getInt("loves"));
                        videosDao.setTitle(resultSet.getString("title"));
                        videosDao.setUrl(resultSet.getString("url"));
                        arrayList.add(videosDao);
                        id=videosDao.getId();
                        uu=JSON.toJSONString(videosDao);
                        jedis6383.set(String.valueOf(id),uu);
                        jedis6383.expire(String.valueOf(id),30*24*3600);
                    }
                } catch (SQLException e) {
                    LOGGER.error("this is an error when create statement: ",e);
                }
            json=JSON.toJSONString(arrayList);

                jedis6383.close();
            return  json;
        }






          public  String GetOneVIdeos(VideosDao video){
             String json=null;
             int i=0;
             int id=video.getId();
             Jedis jedis6383=new Jedis(HOST,6383);
             Set ss=jedis6383.keys(String.valueOf(id));
              Iterator iterator=ss.iterator();
             while (iterator.hasNext()){
                 String iid= (String) iterator.next();
                 json=jedis6383.get(iid);
                 i=1;
                 LOGGER.info("从redis 里面查询出数据 id"+iid+"url "+json);
                 jedis6383.close();
             }

             if (i==0){
                 LOGGER.info("redis里面没有数据 县查询 SQL");
                 Connection conn=getcoon();
                 VideosDao videosDao=new VideosDao();
                 String sql="select * from videos where id="+id;
                 LOGGER.info("this is my sql :"+sql);
                 try {
                     Statement statement=conn.createStatement();
                   ResultSet resultSet=statement.executeQuery(sql);
                   while (resultSet.next()){
                       videosDao.setUrl(resultSet.getString("url"));
                       videosDao.setId(resultSet.getInt("id"));
                       videosDao.setTitle(resultSet.getString("title"));
                       videosDao.setLoves(resultSet.getInt("loves"));
                       json=JSON.toJSONString(videosDao);
                       jedis6383.set(String.valueOf(resultSet.getInt("id")),json);
                       jedis6383.expire(String.valueOf(videosDao.getId()),20);
                       jedis6383.close();
                       LOGGER.info("redis 信息已经更新");

                   }
                   statement.close();
                   conn.close();

                 } catch (SQLException e) {
                     LOGGER.error("this is an error when create statement",e);
                 }

             }
             return  json;

          }
//    public String GetOneNews(NewsDao user){
//        int newsid=user.getId();
//        String json=null;
//        Jedis jedis6380=new Jedis(HOST,6380);
//        Set ss=jedis6380.keys(String.valueOf(newsid));
//        State state=new State();
//
//        Iterator iterator=ss.iterator();
//        while (iterator.hasNext()){
//            String iid= (String) iterator.next();
//            json=jedis6380.get(iid);
//            LOGGER.info("this is message from redis6380: "+json);
//            if (!(json==null)){
//                state.setState(1);
//
//            }else state.setState(0);
//
//        }
//
//        if (state.getState()==1){
//            LOGGER.info("数据从Redis 中获取成功");
//            jedis6380.close();
//            return json;
//        }else {
//            String json1=null;
//            String idd = null;
//            NewsDao newsDao=new NewsDao();
//            LOGGER.info("数据从Redis 中获取失败 ，现在查询数据库.............");
//            System.out.println("数据从Redis 中获取失败 ，现在查询数据库.............");
//            Connection coon=null;
//            coon=getcoon();
//            try {
//                LOGGER.info("数据从Redis 中获取失败 ，现在查询数据库.............");
//                System.out.println("数据从Redis 中获取失败 ，现在查询数据库.............");
//                Statement statement=coon.createStatement();
//                String sql="select * from news where id="+user.getId();
//                LOGGER.info("this is mysql .... :"+sql);
//                ResultSet resultSet=statement.executeQuery(sql);
//                while (resultSet.next()){
//                    newsDao.setId(resultSet.getInt("id"));
//                    idd= String.valueOf(newsDao.getId());
//                    newsDao.setUrl(resultSet.getString("url"));
//                    newsDao.setTitle(resultSet.getString("title"));
//                    newsDao.setLoves(resultSet.getInt("loves"));
//                    newsDao.setFromm(resultSet.getString("fromm"));
//                }
//                json1=JSON.toJSONString(newsDao);
//
//                jedis6380.set(idd,json1);
//                jedis6380.expire(idd,10*24*60*60);
//                jedis6380.close();
//
//                statement.close();
//                coon.close();
//
//            } catch (SQLException e) {
//                LOGGER.error("this is an error when create statement: ",e);
//            }
//
//            return json1;
//
//        }
//

    }

