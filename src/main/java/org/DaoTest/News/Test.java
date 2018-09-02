package org.DaoTest.News;

import org.Control.GetNews;
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
//        String aa=getNews.GetAll();
//        System.out.println(aa);

        String rrr=null;
        NewsDao newsDao=new NewsDao();
        newsDao.setId(3);
        rrr=getNews.GetOneNews(newsDao);
        System.out.println(rrr);

    }
}
