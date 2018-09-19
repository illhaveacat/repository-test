package com.tota.datadict.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class DataSourcePool {

    private static String url;

    private static String username;

    private static String  password;

    private static LinkedList<Connection> pool;

    private static final int size = 10;

    static {
        try {
            //加载MySql的驱动类
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("找不到驱动程序类 ，加载驱动失败！");
            e.printStackTrace();
        }
    }

    private static Connection newConnection() throws SQLException {
        Connection con = DriverManager.getConnection(url, username, password);
        return con;
    }

    public static void loadPool() throws SQLException {
        pool = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            pool.add(newConnection());
        }
    }

    public Connection getConnetion(String url, String username, String password) throws SQLException {
        if(null==pool||pool.size()<1){
            loadPool();
        }
        return pool.removeLast();
    }


}
