package cn.tedu;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;

public class Demo1 {
    public static void main(String[] args) {
        try(Connection conn=DBUtils.getConn();) {
            Statement s=conn.createStatement();
            s.execute("create table hero(id int,name varchar(20))");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
