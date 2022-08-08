package cn.tedu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo5 {
    public static void main(String[] args) {
        try(Connection conn=DBUtils.getConn()) {
            Statement s=conn.createStatement();
            s.executeUpdate("delete from hero where name='孙悟空'");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
