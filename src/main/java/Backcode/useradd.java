package Backcode;

import Utiltool.dbUtil.dbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

/**
 * @author 19086
 * @version 1.0
 * Create by 2023/3/25 21:53
 */

public class useradd {
    /*
     * @Author Langxecho
            * @Description //TODO 新建一条用户数据
     * @Date 22:16 2023/3/25
     * @Param
            * @return
            **/
    public static void creatAccount(String username, String passworld) throws Exception {
    String sql = "insert into user values ("+ getID() +",0.00,1,?,?)";

        dbUtil db = new dbUtil();
        Connection con = db.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
    pstmt.setString(1,username);
    pstmt.setString(2,passworld);
    pstmt.executeUpdate();
    db.closeConnection(con);
    }



    /*
     * @Author Langxecho
            * @Description //TODO 生成8位随机数作为用户id,并且不重复
     * @Date 21:53 2023/3/25
     * @Param
            * @return
            **/
    static int getID() throws Exception {
        String sql = "Select * from user";
        Random random = new Random();
        double a = random.nextDouble();
        int result = (int)(a * 100000000);
        dbUtil db = new dbUtil();
        Connection con = db.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()){
            int id = rs.getInt("id");
            if (result == id){
                result = getID();
            }
        }
        db.closeConnection(con);
        return result;
    }
}
