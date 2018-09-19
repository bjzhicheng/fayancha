package org.OSS;

import com.aliyun.oss.OSSClient;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Date;

/**
 * @Author: yanshilong
 * @Date: 18-9-13 下午11:25
 * @Version 1.0
 */
public class picOSS {
    public  String picOSS(String path) throws Exception {
     File file=new File(path);
        InputStream fis = new FileInputStream(file);
        byte[] xx=new  byte[1024000];
        while (fis.read(xx)>0){

        }//WqfX6x0roPIEy9Y9WBJ28hhMyoEBrk
        //LTAIFUl1eyqqM1YV


        String endpoint = "oss-cn-qingdao.aliyuncs.com";
        // 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录
        // https://ram.console.aliyun.com 创建
        String accessKeyId = "LTAIFUl1eyqqM1YV";
        String accessKeySecret = "WqfX6x0roPIEy9Y9WBJ28hhMyoEBrk";
        // 创建OSSClient实例
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        // 上传
        long time = new Date().getTime();//new ByteArrayInputStream(uploadFile.getBytes())
        ossClient.putObject("fayancha", "Picture", new ByteArrayInputStream(xx));
        // 关闭client
        ossClient.shutdown();
        Date expiration = new Date(new Date().getTime() + 3600l * 1000 * 24 * 365 * 10);
        String url = ossClient.generatePresignedUrl("fayancha", "Picture", expiration).toString();
        System.out.println(url);
        return url;
    }
}
