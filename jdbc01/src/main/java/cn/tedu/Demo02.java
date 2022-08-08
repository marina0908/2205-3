package cn.tedu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo02 {
    public static void main(String[] args) throws SQLException {
        Connection connection= DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/empdb?characterEncoding=utf8&serverTimezone=Asia/Shanghai&useSSL=false",
                "root","l73351503");
        System.out.println(connection);
        Statement s1=connection.createStatement();
        s1.execute("drop table jdbct1");
        connection.close();
        System.out.println("执行完成");
    }
}
