package Backcode;

import static org.junit.jupiter.api.Assertions.*;

class useraddTest {
    public static void main(String[] args) throws Exception {
//        useradd a = new useradd();
//        System.out.println(a.getID());
        try {
            useradd.creatAccount("王子恒","123456");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}