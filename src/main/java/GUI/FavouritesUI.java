package GUI;

import javax.swing.*;

public class FavouritesUI extends JPanel {
    public FavouritesUI() {
        setLayout(null);

//        表格
        String[] colunmName = {"商品", "库存", "购买数量","价格(元)"};
        String[][] tableValues = {{"农夫山泉", "50", "5", "10"}, {"冰红茶", "50", "5", "15"}};
        JTable table = new JTable(tableValues, colunmName) {
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
