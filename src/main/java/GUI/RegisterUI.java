package GUI;

import Utiltool.GuiUtil.getMiddlelocation;

import javax.swing.*;

public class RegisterUI extends JFrame{
    public static void showRegister() {
//        界面设置
        JFrame login = new JFrame();
        login.setSize(400, 300);
        login.setTitle("账户注册");
        login.setDefaultCloseOperation(EXIT_ON_CLOSE);

//        容器设置
        JPanel root = new JPanel();
        login.setContentPane(root);
        login.setResizable(false);
        root.setLayout(null);

//        输入用户名
        JLabel act = new JLabel("新用户名");
        act.setBounds(50, 35, 70, 30);
        root.add(act);

        JTextField Act = new JTextField();
        Act.setBounds(130, 35, 150, 25);
        root.add(Act);

//        输入密码
        JLabel psd = new JLabel("新密码");
        psd.setBounds(50, 75, 70, 30);
        root.add(psd);

        JTextField Psd = new JTextField();
        Psd.setBounds(130, 75, 150, 25);
        root.add(Psd);

//        重复密码
        JLabel psd2 = new JLabel("重复新密码");
        psd2.setBounds(50, 115, 70, 30);
        root.add(psd2);

        JTextField Psd2 = new JTextField();
        Psd2.setBounds(130, 115, 150, 25);
        root.add(Psd2);

//        注册按钮
        JButton button = new JButton("注册");
        button.setBounds(145, 170, 120, 30);
        root.add(button);

//        窗口位置居中
        int[] location = new getMiddlelocation().getMiddlelocation(login);
        login.setLocation(location[0], location[1]);

//        login.setVisible(true);
    }
}
