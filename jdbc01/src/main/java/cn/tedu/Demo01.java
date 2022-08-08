package cn.tedu;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

public class Demo01 {
    public static void main(String[] args) throws SQLException {
        Connection conn=DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/empdb?characterEncoding=utf8&serverTimezone=Asia/Shanghai&useSSL=false",
                "root","l73351503");
        System.out.println("连接对象："+conn);
        Statement s =conn.createStatement();
        s.execute("create table jdbct1(id int)");
        conn.close();
        System.out.println("执行完成！");
    }

}
