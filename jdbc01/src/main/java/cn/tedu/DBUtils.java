package cn.tedu;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
    private  static  DruidDataSource dds;

    static {
        //创建连接池对象
        dds=new DruidDataSource();
        //设置连接数据库的信息
        dds.setUrl("jdbc:mysql://localhost:3306/empdb?characterEncoding=utf8&serverTimezone=Asia/Shanghai&useSSL=false");
        dds.setUsername("root");
        dds.setPassword("l73351503");
        //设置初始对象
        dds.setInitialSize(3);
        //设置最大连接数量
        dds.setMaxActive(5);

    }
    public  static Connection getConn() throws SQLException {
        //从连接池中获取连接对象
        Connection conn =dds.getConnection();
        return conn;
    }
}
