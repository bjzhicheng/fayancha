package org.Control;

import com.alibaba.fastjson.JSON;
import org.DaoTest.News.NewsDao;
import org.Util.JdbcPool;
import org.Util.State;
import org.apache.log4j.Logger;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/**
 * @Author: yanshilong
 * @Date: 18-9-2 上午10:21
 * @Version 1.0
 */


//
// id    | int(10)      | NO   | PRI | NULL    |       |
//         | url   | varchar(20)  | YES  |     | NULL    |       |
//         | loves | int(10)      | YES  |     | NULL    |       |
//         | title | varchar(200) | YES  |     | NULL    |       |
//         | fromm | varchar(100) | YES  |     | NULL    |       |
//         +-------+--------------+------+-----+---------+-
public class GetNews {
    private static Logger LOGGER=Logger.getLogger(GetNews.class);
   // String HOST="127.0.0.1";


    static Connection getcoon(){
        Connection coon= (Connection) JdbcPool.get();
        return coon;
    }

    public State GetAll(){
        State state=new State();
        ArrayList<NewsDao> arrayList=new ArrayList<>();
       // NewsDao news=new NewsDao();
        String json=null;
       Connection connection=null;
       connection=getcoon();
        String sql="select * from news ";
        LOGGER.info("this is my sql : "+sql);

        try {

            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(sql);
            for(int ii=0;ii<50;ii++) {
                while (resultSet.next()) {
                    NewsDao news=new NewsDao();
                    news.setFromm(resultSet.getString("fromm"));
                    news.setId(resultSet.getInt("id"));
                    news.setLoves(resultSet.getInt("loves"));
                    news.setTitle(resultSet.getString("title"));
                    news.setUrl(resultSet.getString("url"));
                    news.setMessage(resultSet.getString("message"));



                    arrayList.add(news);
                    String ss=JSON.toJSONString(news);
                    System.out.println(ss);
                }
            }
        } catch (SQLException e) {
            LOGGER.error("this is an error when create statemen: ",e);
        }


        System.out.println("长度======="+arrayList.size());

       json=JSON.toJSONString(arrayList);
        System.out.println(json);
        state.setMessage(json);
        state.setState(1);
        return  state;
    }



    public State GetOneNews(NewsDao user){

        State state=new State();
        int newsid=user.getId();
        String json=null;
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
            String json1=null;
            String idd = null;
            NewsDao newsDao=new NewsDao();
            LOGGER.info("数据从Redis 中获取失败 ，现在查询数据库.............");
            System.out.println("数据从Redis 中获取失败 ，现在查询数据库.............");
            Connection coon=null;
            coon=getcoon();
            ArrayList array=new ArrayList();
            try {
                LOGGER.info("数据从Redis 中获取失败 ，现在查询数据库.............");
                System.out.println("数据从Redis 中获取失败 ，现在查询数据库.............");
                Statement statement=coon.createStatement();
                String sql="select * from news where id="+user.getId();
                LOGGER.info("this is mysql .... :"+sql);
                ResultSet resultSet=statement.executeQuery(sql);
                while (resultSet.next()){
                    newsDao.setId(resultSet.getInt("id"));
                    idd= String.valueOf(newsDao.getId());
                    newsDao.setUrl(resultSet.getString("url"));
                    newsDao.setTitle(resultSet.getString("title"));
                    newsDao.setLoves(resultSet.getInt("loves"));
                    newsDao.setFromm(resultSet.getString("fromm"));
                    newsDao.setMessage(resultSet.getString("message"));
                    array.add(newsDao.getId());//id
                    array.add(newsDao.getUrl());//图片URL
                    array.add(newsDao.getFromm());//来源
                    array.add(newsDao.getLoves());//loves
                    array.add(newsDao.getTitle());//title
                    array.add(newsDao.getMessage());//内容

                }
                String aa=String.valueOf(array);

//                jedis6380.set(idd,aa);
//                jedis6380.expire(idd,10*24*60*60);
//                jedis6380.close();
                json=JSON.toJSONString(array);
                state.setMessage(json);
                state.setState(1);
                statement.close();
                coon.close();

            } catch (SQLException e) {
                LOGGER.error("this is an error when create statement: ",e);
            }

              return state;

        }





    }






