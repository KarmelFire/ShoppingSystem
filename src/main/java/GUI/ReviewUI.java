package GUI;

import javax.swing.*;
import java.awt.*;

/*
 * @Author Langxecho
 * @Description //TODO 用户评论查看ui
 * @Date 18:52 2023/3/20
 **/
public class ReviewUI {
public JFrame generatereview(){
    JFrame review = new JFrame();
    review.setSize(600,400);
    review.setVisible(true);
    review.setTitle("评论区");
    Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (int)((screensize.getWidth() - review.getWidth()) / 2);
    int y = (int)((screensize.getHeight() - review.getHeight()) / 2);
    review.setLocation(x,y);
    return review;
}

}
