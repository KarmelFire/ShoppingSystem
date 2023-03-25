package GUI;

import javax.swing.*;
import java.awt.*;

public class UserinforUI extends JPanel {
    String user = null;//用户名
    String id = null;//用户id
    String vip = "否";//是否是VIP
    double balance = 0.0;//用户余额
    JButton changename = new JButton("修改");//修改用户名按钮
    JButton getVIP = new JButton("充值");//充值按钮

    //占位符
    String empty = "                                                                                                                                                                                                                                                                                                                                                                                               ";
    public UserinforUI() {
        setLayout(null);
        //信息承载面板设置
        JPanel undertake = new JPanel();
        undertake.setBounds(20,24,740,500);
        undertake.setBackground(Color.WHITE);
        undertake.setLayout(new FlowLayout(FlowLayout.LEFT));
        add(undertake);
//        字体设置
        Font font = new Font("微软雅黑", Font.PLAIN, 22);

//        用户名
        JLabel name = new JLabel("用户名:");
        name.setFont(font);
        name.setBounds(50, 30, 80, 45);
        add(name);

        JLabel Name = new JLabel("XXX");
        Name.setFont(font);
        Name.setBounds(130, 30, 100, 45);
        add(Name);
    }
}
