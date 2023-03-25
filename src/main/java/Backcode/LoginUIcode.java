package Backcode;

import Utiltool.dbUtil.dbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.EventListener;
import java.util.Objects;

/**
 * @ClassName a
 * @Description TODO
 * @Author BC
 * @Date 2023/3/20 18:23
 * @Version 1.0
 */
public class LoginUIcode {
    Connection con;

    /*
     * @Author Langxecho
            * @Description //TODO 得到输入的用户名与密码,并进行核对
     * @Date 16:24 2023/3/25
     * @Param
            * @return
            **/
    public  String judgeInformation(String user,String passworld) throws Exception{
        //执行用户名与密码的核对
        String a[] = checkuser(user);
        System.out.println(a[0] +" "+ a[1]+ " "+a[2]);
        if (a[0] == null) {return "NOT FOUND USER";}
        else {
            if (passworld.equals(a[1]) && a[2].equals("0")){
                return "ADMIN PASS";
            } else if (passworld.equals(a[1]) && a[2].equals("1")) {return "PASS";

            } else {return "PASSWORLD ERROR";}
        }
    }
    /*
     * @Author Langxecho
            * @Description //TODO 遍历数据库的所有用户名,并且不断返回
     * @Date 16:46 2023/3/25
     * @Param
            * @return
            **/
    String[] checkuser(String user) throws Exception {
        String userblank[] = new String[3];
        //查库指令
        String sql = "Select * from user";
        //获取数据库连接
        dbUtil dbUtil = new dbUtil();
        con = dbUtil.getConnection();
        System.out.println("数据库连接成功");
        PreparedStatement pstmt = con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()){
            String username = rs.getString("username");
            String passworld = rs.getString("passworld");
            String identity = rs.getString("identity");
            System.out.println(username + passworld + identity);
            System.out.println(user);
            userblank[0] = username;
            userblank[1] = passworld;
            userblank[2] = identity;
            if (user.equals(username)) return userblank;
        }
        userblank[0] = null;
        userblank[1] = null;
        userblank[2] = null;
        dbUtil.closeConnection(con);

        return userblank;
    }
}
