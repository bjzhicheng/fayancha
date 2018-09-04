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

    public  String GetAllVideos(){

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






}

