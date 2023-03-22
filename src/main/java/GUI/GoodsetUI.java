package GUI;

import javax.swing.*;

public class GoodsetUI extends JPanel {
    public GoodsetUI() {
        setLayout(null);

//        表格
        String[] rowName = {"商品", "分类", "价格", "折扣", "库存"};
        String[][] tableValues = {{"农夫山泉", "饮料", "2", "无", "50"}, {"冰红茶", "饮料", "3", "无", "50"}};
        JTable table = new JTable(tableValues, rowName);

//        滚动
        JScrollPane scrollPane = new JScrollPane(
                table,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
        );
        scrollPane.setBounds(30, 30, 728, 470);
        add(scrollPane);

        JPopupMenu menu = new JPopupMenu();
        JMenuItem checkItem = new JMenuItem("查看详情");
        JMenuItem addItem = new JMenuItem("添加购物车");
        JMenuItem buyItem = new JMenuItem("购买商品");
        menu.add(checkItem);
        menu.add(addItem);
        menu.add(buyItem);


    }
}
