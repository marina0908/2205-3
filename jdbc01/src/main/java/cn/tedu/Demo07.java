package cn.tedu;

import java.sql.*;
import java.util.Scanner;

public class Demo07 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String username=sc.nextLine();
        String password=sc.nextLine();

        try (Connection conn=DBUtils.getConn()){
//            Statement s=conn.createStatement();

//            ResultSet rs=s.executeQuery("select username,password from user");
//            while (rs.next()){
//                String na=rs.getString(1);
//                String pw=rs.getString(2);
//                if(username.equals(na) &&password.equals(pw)){
//                    System.out.println("登陆成功："+na);
//                }else{
//                    System.out.println("登陆失败");
//                }
//            }
//            String sql="select count(*) as c from user where username='"+username+"' and password='"+password+"'";
//            ResultSet rs=s.executeQuery(sql);


            //此种够写法，当用户名输入错误，密码输入：' or '1'='1   时能登陆成功
//            String sql="select count(*) as c from user where username='"+username+"' and password='"+password+"'";
//            ResultSet rs=s.executeQuery(sql);
            //通过preparedstatement解决sql注入问题
            String sql="select count(*)  from user where username=? and password=?";
            //prepare  准备   statement  声明,说明，陈述
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
