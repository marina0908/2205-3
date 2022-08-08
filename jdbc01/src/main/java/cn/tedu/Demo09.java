package cn.tedu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Demo09 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入姓名");
        String username=sc.nextLine();
        System.out.println("请输入密码");
        String password=sc.nextLine();
        System.out.println("请输入昵称");
        String nick = sc.nextLine();

        try (Connection conn=DBUtils.getConn()){
            //通过用户名输入的用户名查询是否有数据
            //有数据提示用户名已经存在
            //如果没有数据在往数据库里面存入数据
            String sql="select id from user where username=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,username);
            ResultSet re=ps.executeQuery();

            if (re.next()){
                System.out.println("用户已存在");
            }else{
                String insertSql="insert into user values (null,?,?,?)";
                ps=conn.prepareStatement(insertSql);
                ps.setString(1,username);
                ps.setString(2,password);
                ps.setString(3,nick);
                ps.executeUpdate();
                System.out.println("注册成功");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
