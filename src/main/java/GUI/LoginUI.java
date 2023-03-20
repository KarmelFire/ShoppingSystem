package GUI;

import Utiltool.GuiUtil.getMiddlelocation;

import javax.swing.*;
import java.awt.*;


public class LoginUI extends JFrame {
    public static void showlogin() {
        JFrame login = new JFrame();
        login.setSize(400, 300);
        login.setTitle("账户登录");
        login.setDefaultCloseOperation(EXIT_ON_CLOSE);

//        容器设置
        JPanel root = new JPanel();
        login.setContentPane(root);
        login.setResizable(false);
        root.setLayout(null);

//        输入用户名
        JLabel act = new JLabel("用户名");
        act.setBounds(60, 40, 50, 30);
        root.add(act);

        JTextField Act = new JTextField();
        Act.setBounds(130, 40, 150, 25);
        root.add(Act);

//        输入密码
        JLabel psd = new JLabel("密码");
        psd.setBounds(60, 100, 50, 30);
        root.add(psd);

        JTextField Psd = new JTextField();
        Psd.setBounds(130, 100, 150, 25);
        root.add(Psd);

//        登录按钮
        JButton button = new JButton("登录");
        button.setBounds(145, 160, 120, 30);
        root.add(button);

        JLabel label = new JLabel("点击注册账号");
        label.setBounds(173, 190, 100, 30);
        Font font = new Font("微软雅黑", Font.PLAIN, 10);
        label.setFont(font);
        root.add(label);

//        窗口位置居中
        int[] location = new getMiddlelocation().getMiddlelocation(login);
        login.setLocation(location[0], location[1]);

//        login.setVisible(true);
    }
}
;