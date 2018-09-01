package org.mainServer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: yanshilong
 * @Date: 18-8-31 下午2:36
 * @Version 1.0
 */
public class WorkThreadPool {
    public static ExecutorService pool= Executors.newCachedThreadPool();
    public static void doWork(Runnable runnable){
        pool.execute(runnable);
//        pool.submit(runnable);

    }

    public static void main(String[] args) {
       for (int i=0;i<3;i++){
           Runnable runnable=new Runnable() {
               @Override
               public void run() {
                   System.out.println("POLL");
               }
           };
           pool.execute(runnable);
       }
//        pool.shutdown();
//        pool.submit();
    }
}
