package org.JDBC;

import java.sql.Connection;

/**
 * @Author: yanshilong
 * @Date: 18-8-19 下午3:15
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        Connection c=JDBCConnection.getconnection();
    }
}
