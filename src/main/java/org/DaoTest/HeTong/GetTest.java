package org.DaoTest.HeTong;

import com.alibaba.fastjson.JSON;
import org.Control.GetHetong;
import org.Util.State;
import org.apache.log4j.PropertyConfigurator;

/**
 * @Author: yanshilong
 * @Date: 18-8-21 下午2:30
 * @Version 1.0
 */
public class GetTest {
    public static void main(String[] args) {
        PropertyConfigurator.configure("/home/syl/project/Law/src/main/resources/LOG4j/Log4j.properties");
        GetDao gg=new GetDao();
        gg.setId(6668077);

//        gg.setHetongid("2_htttp://8080//hhh");
//        GetHetong getHetong=new GetHetong();
//        getHetong.get(gg);

        GetHetong getHetong=new GetHetong();
       //State state= getHetong.getall(gg);

        State state=getHetong.getOne(gg);
        System.out.println(state.getMessage());

        System.out.println(JSON.toJSONString(state));
    }
}
