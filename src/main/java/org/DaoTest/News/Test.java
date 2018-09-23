package org.DaoTest.News;

import com.alibaba.fastjson.JSON;
import org.Control.GetNews;
import org.Util.State;
import org.apache.log4j.PropertyConfigurator;

/**
 * @Author: yanshilong
 * @Date: 18-9-2 上午10:22
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        PropertyConfigurator.configure("/home/syl/project/Law/src/main/java/org/log4j.properties");
        GetNews getNews=new GetNews();
        NewsDao u=new NewsDao();
        u.setId(1);
      //  State state=getNews.GetAll(u);

        State state=getNews.GetOneNews(u);
//        System.out.println(aa);

//        String rrr=null;
//        NewsDao newsDao=new NewsDao();
//        newsDao.setId(3);
       // State state =getNews.GetOneNews(newsDao);
        String ss=JSON.toJSONString(state);
        System.out.println(ss);

    }
}
