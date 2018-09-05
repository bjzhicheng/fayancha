package org.Util;

/**
 * @Author: yanshilong
 * @Date: 18-9-5 下午10:38
 * @Version 1.0
 */
public class PoolTest {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println("ppppppppp");
                }
            };
     WorkThreadPool.pool.execute(runnable);

        }
    }
}
