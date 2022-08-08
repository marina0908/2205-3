package cn.tedu;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo2 {
    public static void main(String[] args) {
        try(Connection conn=DBUtils.getConn()) {
            Statement s=conn.createStatement();
            s.executeUpdate("insert into hero(name) values('刘备'),('关羽'),('张飞')");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
