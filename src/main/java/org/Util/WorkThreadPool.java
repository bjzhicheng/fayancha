package org.Util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: yanshilong
 * @Date: 18-9-5 下午10:21
 * @Version 1.0
 */
public class WorkThreadPool {
    public static ExecutorService pool = Executors.newCachedThreadPool();

    public void dowork(Runnable runnable) {
        pool.execute(runnable);
        //  pool.submit(runnable);

    }

}

//    public static void main(String[] args) {
//        for(int i=0;i<20;i++){
//            Runnable runnable=new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println("ppppppppp");
//                }
//            };
//            pool.execute(runnable);
//
//        }
//    }



//    ublic class WorkThreadPool {
//        public static ExecutorService pool= Executors.newCachedThreadPool();
//        public static void doWork(Runnable runnable){
//            pool.execute(runnable);
////        pool.submit(runnable);
//
//        }
//
//        public static void main(String[] args) {
//            for (int i=0;i<3;i++){
//                Runnable runnable=new Runnable() {
//                    @Override
//                    public void run() {
//                        System.out.println("POLL");
//                    }
//                };
//                pool.execute(runnable);
//            }
//            pool.shutdown();
////        pool.submit();
//        }
//    }


