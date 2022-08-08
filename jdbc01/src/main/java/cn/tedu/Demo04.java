package cn.tedu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo04 {
    public static void main(String[] args) {
        //调用工具类中的方法获取连接对象
        try(Connection connection=DBUtils.getConn();) {
            //创建执行sql语句
            Statement s =connection.createStatement();
            //执行查询
            ResultSet rs=s.executeQuery("select name from emp");
            //遍历结果集对象
            while (rs.next()){
                String name=rs.getString(1);
                System.out.println(name);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
