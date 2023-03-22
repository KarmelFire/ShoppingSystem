package GUI;

import javax.swing.*;
import java.awt.*;

public class UserinforUI extends JPanel {
    public UserinforUI() {
        setLayout(null);

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
