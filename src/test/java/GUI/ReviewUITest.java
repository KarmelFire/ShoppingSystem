package GUI;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class ReviewUITest {
    public static void main(String[] args) {
ReviewUI a = new ReviewUI();
        JFrame s = a.generatereview();
      a.reviewarea("yonghuhu","今天是个好日子啊");
        a.reviewarea("yonghuhu","123");
        a.reviewarea("yonghuhu","12");
        a.reviewarea("yonghuhu","123");
        a.reviewarea("yonghuhu","123");
        a.reviewarea("yonghuhu","123");
        a.reviewarea("yonghuhu","123");
        s.setVisible(true);


    }

}