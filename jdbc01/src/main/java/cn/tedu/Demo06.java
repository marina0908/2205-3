package cn.tedu;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Demo06 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in );
        String username=sc.nextLine();
        String password= sc.nextLine();
        String nickName= sc.nextLine();

        try(Connection conn=DBUtils.getConn()) {
            Statement s=conn.createStatement();
            String sql="";
            s.executeUpdate("insert into user values (null,'"+username+"','"+password+"','"+nickName+"')");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}

