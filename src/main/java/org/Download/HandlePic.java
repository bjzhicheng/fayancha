package org.Download;


import org.ShenHe.ShenCha;
import org.ShenHe.UserDao;
import org.Util.State;
import org.apache.log4j.PropertyConfigurator;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import redis.clients.jedis.BinaryClient;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yanshilong
 * @Date: 18-9-21 下午5:02
 * @Version 1.0
 */
public class HandlePic {

//    public String  handle(String json){
//
//        //"count":2,
//        JSONObject jsonObject = null;
//
//        try {
//            jsonObject=new JSONObject(json);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        //  jsonObject = new JSONObject(json);
//
//        String filenames="";
//        int i=1;
//        while (jsonObject.length()!=1){
//            try {
//                filenames=jsonObject.getString("url"+i)+" "+filenames;
//            } catch (JSONException e) {
////                logger.info("JSONException");
//                e.printStackTrace();
//            }
//            jsonObject.remove("url"+i);
//            i++;
//
//        }
//        System.out.println(filenames);
//        String[] urls=filenames.split(" ");
//        String path="";
//        DownloadPic downloadPic=new DownloadPic();
//        for (String url:urls) {
//            System.out.println(url);
//            path=url+" "+path;
//            downloadPic.download(url);
//
//        }
//        return path;
//    }

    public String handle (List parmList){
        String fileName="";
        String fileNames="";

        DownloadPic downloadPic=new DownloadPic();

        while (parmList.size()!=1) {
            fileName= (String) parmList.get(1);
            downloadPic.download(fileName);
            fileNames = fileName + " ";
            parmList.remove(1);
        }
        return fileNames;
    }




    public static void main(String[] args) throws JSONException {
        PropertyConfigurator.configure("/home/syl/project/Law/src/main/resources/LOG4j/Log4j.properties");

        String json="{\"id\":\"123\",\"url1\":\"Picture/1951070349.jpg\"}";
//
//        //"count":2,
//        JSONObject jsonObject = new JSONObject(json);
//
//        String hetong="";
//        int i=1;
//        while (jsonObject.length()!=1){
//            hetong=jsonObject.getString("url"+i)+" "+hetong;
//            jsonObject.remove("url"+i);
//            i++;
//
//        }
//        System.out.println(hetong);
//        String[] urls=hetong.split(" ");
//        DownloadPic downloadPic=new DownloadPic();
//        for (String url:urls) {
//            System.out.println(url);
//            downloadPic.download(url);
//        }




//        //测试
//
//
//
//
//
//        System.out.println(changePic.ChangePic(path));


        List list=new ArrayList();
        list.add("1");
        list.add("Picture/1951070349.jpg");

        HandlePic handlePic=new HandlePic();
        String path=handlePic.handle(list);
//
        System.out.println(path);
//
//       // String path="/home/syl/文档/Picture/1951070349.jpg";
//
        ChangePic changePic=new ChangePic();
                System.out.println(changePic.ChangePic(path));
                String aaa=changePic.ChangePic(path);

        UserDao newuser=new UserDao();
        newuser.setUserid(Integer.parseInt(String.valueOf(list.get(0))));
        newuser.setMessage(aaa);


        State state=new State();
        ShenCha shenCha=new ShenCha();
         state= shenCha.DoShenCha(newuser);



        System.out.println(state.getState());



    }



}
