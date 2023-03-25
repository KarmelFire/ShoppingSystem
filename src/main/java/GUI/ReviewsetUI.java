package GUI;

import Utiltool.GuiUtil.getMiddlelocation;
import Utiltool.GuiUtil.reviewContent;

import javax.swing.*;
import java.awt.*;

public class ReviewsetUI {
    public static void showReviewSet() {
        JFrame reviewSet = new JFrame("评论管理");
        reviewSet.setSize(600, 400);
        reviewSet.setResizable(false);

        JPanel root = new JPanel();
        reviewSet.setContentPane(root);
        root.setLayout(null);

        JPanel content = new JPanel();
        content.setBackground(Color.white);
        root.add(content);

        JScrollPane scrollPane = new JScrollPane(
                content,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
        );
        scrollPane.setBounds(18, 50, 552, 270);
        root.add(scrollPane);

        JButton back = new JButton("返回");
        back.addActionListener((e) -> {
            reviewSet.dispose();
        });
        back.setBounds(509, 326, 60, 30);
        root.add(back);

        content.add(reviewContent.review());





//        窗口位置居中
        int[] location = getMiddlelocation.getMiddlelocate(reviewSet);
        reviewSet.setLocation(location[0], location[1]);

        reviewSet.setVisible(true);
    }
}
