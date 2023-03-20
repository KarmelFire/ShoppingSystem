package GUI;

import javax.swing.*;

public class LoginUI extends JFrame {
    public LoginUI(String title) {
        super(title);

        JPanel root = new JPanel();
        this.setContentPane(root);
        root.setLayout(null);


        root.add (new JLabel("账号"));
        root.add (new JTextField(15));

        root.add (new JLabel("密码"));
        root.add (new JTextField(15));

    }
}
