package org.Download;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.GetObjectRequest;

import java.io.File;

/**
 * @Author: yanshilong
 * @Date: 18-9-21 下午5:02
 * @Version 1.0
 */
public class DownloadPic {

    private static String endpoint = "http://oss-cn-qingdao.aliyuncs.com";

    private  static  String accessKeyId = "LTAIFUl1eyqqM1YV";

    private  static  String accessKeySecret = "WqfX6x0roPIEy9Y9WBJ28hhMyoEBrk";

    private  static String bucketName = "fayancha";

//    private  String objectName=null;
//    public DownloadPic(String objectName){
//        this.objectName=objectName;
//    }

    public void download(String objectName){
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        String path = "/home/syl/文档/Docx/"+objectName;
        System.out.println("图片存储路径------->"+path);
        ossClient.getObject(new GetObjectRequest(bucketName, objectName), new File(path));
        System.out.println("图片已存储");
        ossClient.shutdown();
        System.out.println("链接已关闭");
    }



    public static void main(String[] args) {


//        String endpoint = "http://oss-cn-qingdao.aliyuncs.com";
//// 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
//        String accessKeyId = "LTAIFUl1eyqqM1YV";
//        String accessKeySecret = "WqfX6x0roPIEy9Y9WBJ28hhMyoEBrk";
//        String bucketName = "fayancha";
//        String objectName =  "Picture/150425101035-11.jpg";
//
//
//        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
//// 下载OSS文件到本地文件。如果指定的本地文件存在会覆盖，不存在则新建。
//        System.out.println("xxxxxxxxxx");
//        String path="/home/pp/"+objectName;
//        System.out.println(path);
//        ossClient.getObject(new GetObjectRequest(bucketName, objectName), new File(path));
//        System.out.println("ppppppppppppp");
//// 关闭OSSClient。
//        ossClient.shutdown();


    }
}
