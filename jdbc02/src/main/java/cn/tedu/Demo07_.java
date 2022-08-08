package cn.tedu;

import java.sql.*;
import java.util.Scanner;

public class Demo07_ {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入姓名");
        String username=sc.nextLine();
        System.out.println("请输入密码");
        String password=sc.nextLine();

        try (Connection conn=DBUtils.getConn()){
//            Statement s=conn.createStatement();
            //此种够写法，当用户名输入错误，密码输入：' or '1'='1   时能登陆成功
//            String sql="select count(*) as c from user where username='"+username+"' and password='"+password+"'";
//            ResultSet rs=s.executeQuery(sql);
            //通过preparedstatement解决sql注入问题
            String sql="select count(*)  from user where username=? and password=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            //把？替换成变量
            ps.setString(1,username);
            ps.setString(2,password);
            ResultSet rs=ps.executeQuery();
            rs.next();
            int count=rs.getInt(1)  ;//int count=rs.getInt(1)  ;
            if (count>0){
                System.out.println("登陆成功");

            }else {
                System.out.println("用户名或密码错误！");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
