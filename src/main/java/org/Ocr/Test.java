package org.Ocr;

/**
 * @Author: yanshilong
 * @Date: 18-9-16 上午11:08
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        Ocr doocr=new Ocr();

        String path = "/home/syl/下载/Test.jpg";


        String ss=doocr.DoOcr(path);

        System.out.println(ss);


    }
}
