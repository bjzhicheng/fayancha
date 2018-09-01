package org.Util;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Author: yanshilong
 * @Date: 18-8-19 下午3:02
 * @Version 1.0
 */
public class JDBCConnection {
    static Logger LOGGER = Logger.getLogger(JDBCConnection.class);

    public static Connection getconnection() {
        String DRIVER_CLASS = "com.mysql.jdbc.Driver";
        String URL="jdbc:mysql://127.0.0.1:3306/law";
        String PASS="123456";
        String USERNAME="root";
        Connection coon=null;

        try {
            Class.forName(DRIVER_CLASS);

        } catch (ClassNotFoundException e) {
            LOGGER.debug("this is in fornamejdbc "+e);
        }
        try {
            coon= DriverManager.getConnection(URL,USERNAME,PASS);
        } catch (SQLException e) {

            LOGGER.debug("this is in getconnection"+e);
        }


        return coon;
    }
}



