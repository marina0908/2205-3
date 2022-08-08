package cn.tedu;

import java.sql.*;

public class Demo3 {
    public static void main(String[] args) throws SQLException {
        Connection connection= DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/empdb?characterEncoding=utf8&serverTimezone=Asia/Shanghai&useSSL=false",
                "root","l73351503");

        Statement s=connection.createStatement();
        s.executeUpdate("insert into emp(name) values ('tom')");
        s.executeUpdate("update emp set name='jerry' where name='tom'");
        s.executeUpdate("delete from emp where name='jerry'");
        ResultSet resultSet= s.executeQuery("select  name,sal from emp");
        while (resultSet.next()){
//
            String name=resultSet.getString(1);
            double sal=resultSet.getDouble(2);
            System.out.println(name+":"+sal);
        }

        connection.close();
        System.out.println("执行完成！");

    }
}
