package GUI;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class LoginUITest {
    public static void main(String[] args) {
        LoginUI loginUI = new LoginUI("账户登录");
        loginUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginUI.setSize(400, 300);
        loginUI.setVisible(true);
    }

}