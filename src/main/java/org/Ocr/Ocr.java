package org.Ocr;


import com.baidu.aip.ocr.AipOcr;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * @Author: yanshilong
 * @Date: 18-9-16 上午11:06
 * @Version 1.0
 */
public class
Ocr {
    public static final String APP_ID = "11790704";
    public static final String API_KEY = "EVKfOuLdQhg9PLoIOzZo545v";
    public static final String SECRET_KEY = "KO8cTEqAiIumcqSFUhnUagKv4Iy6qKxX";

    public String DoOcr(String path) {

        String message = "";
        String fanhui=null;
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
        // 调用接口
        //String path = "/home/syl/图片/2018-09-09 01-51-31 的屏幕截图.png";
        JSONObject res = client.basicGeneral(path, new HashMap<String, String>());
        message = res.toString();

       // System.out.println(message);
        String[] aa=message.split("words|:");
        System.out.println("长度为：  "+aa.length);
        for(int i=0;i<aa.length;i++){
                 aa[i]=aa[i].replaceAll("\\{|}","");
            //aa[i]=aa[i].replaceAll("\\}","");
            aa[i]=aa[i].replaceAll("\"|log_id|result|u2026|_result_num|[|]","");
           // System.out.println(aa[i]);
            fanhui=fanhui+aa[i];
        }
        // System.out.println(res);



        return fanhui;
    }
}
