package GUI;

import Utiltool.dbUtil.dbUtil;
import org.springframework.jdbc.support.JdbcUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserinforUI extends JPanel {
    String getUser;
    String user = null;//用户名
    String id = null;//用户id
    String vip = "否";//是否是VIP
    double balance = 0.0;//用户余额
    JButton changename = new JButton("修改");//修改用户名按钮
    JButton getVIP = new JButton("充值");//VIP充值按钮
    JButton addbalance = new JButton("充值");//余额充值按钮
    //占位符
    String empty = "                                                                                                                                                                                                                                                                                                                                                         ";
    JLabel emptys = new JLabel(empty);
    public UserinforUI(String getUser) {
        this.getUser = getUser;
        //数据库加载设置
        try{
            System.out.println("元数据得到的用户名为"+getUser);
            String sql = "select * from user where username =" + getUser;
            dbUtil db = new dbUtil();
            Connection con = db.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            user = rs.getString("username");
            id = rs.getString("id");
            int vipflag = rs.getInt("identity");
            vip = (vipflag == 0 ? "否" : "是");
            System.out.println("元数据加载成功");
            db.closeConnection(con);
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("元数据加载失败");
        }
        //--------------------------------
        setLayout(null);
        //信息承载面板设置
        JPanel undertake = new JPanel();
        undertake.setBounds(20,24,740,500);
        undertake.setBackground(Color.WHITE);
        undertake.setLayout(null);
        add(undertake);
        //字体设置
        Font font = new Font("微软雅黑", Font.PLAIN, 22);
        //用户名区域
        JLabel userfont = new JLabel("用户名:" + user);
        userfont.setFont(font);
        userfont.setBounds(40,80,200,40);
        undertake.add(userfont);
        //用户名修改按钮设置
        changename.setBounds(200,90,60,25);
        undertake.add(changename);
        changename.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //这里添加用户名修改按钮的功能
            }
        });
        //用户id区域设置
        JLabel useridfont = new JLabel("用户id:" + id);
        useridfont.setFont(font);
        useridfont.setBounds(40,120,200,40);
        undertake.add(useridfont);
        //VIP区域设置
        JLabel vipfont = new JLabel("VIP:" + vip);
        vipfont.setFont(font);
        vipfont.setBounds(40,160,200,40);
        undertake.add(vipfont);
        getVIP.setBounds(200,170,60,25);
        undertake.add(getVIP);
        getVIP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //这里添加VIP充值按钮的功能
            }
        });
        //余额界面设置
        JLabel balancefont = new JLabel("账户余额:" + balance + "元");
        balancefont.setFont(font);
        balancefont.setBounds(40,200,200,40);
        undertake.add(balancefont);
        addbalance.setBounds(200,210,60,25);
        undertake.add(addbalance);
        addbalance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //这里添加余额充值按钮的功能
            }
        });
    }
}
