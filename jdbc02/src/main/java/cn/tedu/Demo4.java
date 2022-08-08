package cn.tedu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo4 {
    public static void main(String[] args) {
        try(Connection conn=DBUtils.getConn()) {
            Statement s=conn.createStatement();
            ResultSet rs=s.executeQuery("select name from hero");
            while (rs.next()){
                String name=rs.getString(1);
                System.out.println(name);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
