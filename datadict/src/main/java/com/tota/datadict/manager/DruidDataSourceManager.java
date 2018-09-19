package com.tota.datadict.manager;

import com.alibaba.druid.pool.DruidDataSource;
import com.tota.datadict.exception.BussinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DatabaseMetaData;

public class DruidDataSourceManager {

    private Logger logger = LoggerFactory.getLogger(DruidDataSourceManager.class);

    private String url;

    private String username;

    private String password;

    private Connection conn;

    private DatabaseMetaData databaseMetaData;

    public DruidDataSourceManager(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public static void main(String args[]) throws Exception {
        DruidDataSourceManager dataSourceManager = new DruidDataSourceManager("jdbc:mysql://localhost:3306/db1", "root", "root");
        String url=dataSourceManager.getUrl();
        String databaseName=url.substring(url.lastIndexOf("/")+1);
        System.out.println(databaseName);
    }

    public Connection getConnect() throws Exception {
        if (conn == null || conn.isClosed()) {
            try {
                DruidDataSource dataSource = new DruidDataSource();
                //设置连接参数 (***自己定义传递的参数***)  //localhost:3306/db1
                dataSource.setUrl(url + "?useUnicode=true&characterEncoding=utf-8&useSSL=false");
                dataSource.setDriverClassName("com.mysql.jdbc.Driver");
                dataSource.setUsername(username);
                dataSource.setPassword(password);
                //配置初始化大小、最小、最大
                dataSource.setInitialSize(1);
                dataSource.setMinIdle(1);
                dataSource.setMaxActive(8);
                //连接泄漏监测
                dataSource.setRemoveAbandoned(true);
                dataSource.setRemoveAbandonedTimeout(30);
                //配置获取连接等待超时的时间
                dataSource.setMaxWait(20000);
                //配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
                dataSource.setTimeBetweenEvictionRunsMillis(20000);
                //防止过期
                dataSource.setValidationQuery("SELECT 'x'");
                dataSource.setTestWhileIdle(true);
                dataSource.setTestOnBorrow(true);
                // 建立了连接
                conn = dataSource.getConnection();
            } catch (Exception e) {
                throw new BussinessException("数据库连接异常");
            }
        }
        return conn;
    }

    public DatabaseMetaData getMetaData() throws Exception {
        if (databaseMetaData == null) {
            databaseMetaData = getConnect().getMetaData();
        }
        return databaseMetaData;
    }


    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
