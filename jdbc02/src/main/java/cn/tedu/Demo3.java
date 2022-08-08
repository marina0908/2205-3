package cn.tedu;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo3 {
    public static void main(String[] args) {
        try(Connection conn=DBUtils.getConn()) {
            Statement s=conn.createStatement();
            s.executeUpdate("update hero set name='孙悟空' where name='刘备'");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
