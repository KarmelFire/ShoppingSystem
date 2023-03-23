package GUI;

import javax.swing.*;

public class BuyinforUI extends JPanel {
    public BuyinforUI() {
        setLayout(null);

//        表格
        String[] columnName = {"商品", "购买时间", "购买数量","价格(元)"};
        String[][] tableValues = {{"农夫山泉", "2023/3/22 19:28:36", "5", "10"}, {"冰红茶", "2023/3/22 19:29:44", "5", "15"}};
        JTable table = new JTable(tableValues, columnName) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

//        滚动
        JScrollPane scrollPane = new JScrollPane(
                table,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
        );
        scrollPane.setBounds(30, 30, 728, 470);
        add(scrollPane);
    }
}
