package org.Download;

import org.Ocr.Ocr;

/**
 * @Author: yanshilong
 * @Date: 18-9-21 下午5:00
 * @Version 1.0
 */
public class ChangePic {

//    //调用XwpfTest拿到一个docx文档的String
//    String docx="离婚合同协议的文档";
//
//    //调用张鹏的方法拿到一个String的URL集合
//    String fh="";
//    //int i=0;
//    String json=null;


//    HandlePic handlePic=new HandlePic();
//    String url=handlePic.handle(json);




    public String ChangePic(String url){//url----path
        String fh="";

        String []ary=url.split(" ");
        System.out.println("长度======"+ary.length);
        Ocr ocr=new Ocr();
        int length=ary.length;

        for(int ii=0;ii<length;ii++){
            System.out.println("URL==="+ary[ii]);
            String pic= ocr.DoOcr("/home/syl/文档/Docx/"+ary[ii]);
            fh+=pic;
            ii++;

        }
        return fh;
    }
//    //可以拿到文件和图片的String集合
//    public String Changedocx(){
//        ChangePic changePic=new ChangePic();
//        String pic=changePic.ChangePic(url);
//        String handler=docx+" "+pic;
//
//        return handler;
//    }
}
