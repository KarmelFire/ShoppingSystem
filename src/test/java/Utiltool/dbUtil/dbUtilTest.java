package Utiltool.dbUtil;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class dbUtilTest {


    public static void main(String[] args) {
        dbUtil database = new dbUtil();
       try{
           database.getConnection();
           System.out.println("数据库连接成功");
       }catch (Exception e){
           e.printStackTrace();
           System.out.println("数据库连接失败");
       }

    }

}