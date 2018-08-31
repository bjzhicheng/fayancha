package org.Util;

import java.util.UUID;

/**
 * @Author: yanshilong
 * @Date: 18-8-31 上午12:28
 * @Version 1.0
 */
public class MakeUuid {

    public static int Make() {
      String uu = UUID.randomUUID().toString().replaceAll("-", "");
      int iii = uu.hashCode();
      int aaa = Math.abs(iii);
         return  aaa;

  }
}
