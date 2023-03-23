package GUI;

import javax.swing.*;
import java.awt.*;

public class FavouritesUI extends JPanel {
    String empty1 = "                                                                                                                                                                                                                                                                                                                                                                             ";

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
        table.getTableHeader().setReorderingAllowed(false);   //不可整列移动
        table.getTableHeader().setResizingAllowed(false);   //不可拉动表格
        setLayout(new FlowLayout(FlowLayout.LEFT));

//        滚动
        JLabel emptys = new JLabel(empty1);
        add(emptys);
        add(emptys);

        //添加两行占位符
        JScrollPane scrollPane = new JScrollPane(
                table,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
        );
        scrollPane.setPreferredSize(new Dimension(778,400));
        add(scrollPane);
        //原价总计,折后总计与购买按钮
        add(countbefore());
        add(countafter());
        //购买按钮
        JButton buy = new JButton("购买");
        buy.setSize(80,25);
        add(buy);
    }
    /*
     * @Author Langxecho
            * @Description //TODO 原价总计
     * @Date 8:44 2023/3/23
     * @Param
            * @return
            **/
    JLabel countbefore(){
        double count = 0;
        JLabel label = new JLabel("原价总计:" + count + "                    ");
        return label;
    }
    /*
     * @Author Langxecho
            * @Description //TODO 折后总计
     * @Date 8:57 2023/3/23
     * @Param
            * @return
            **/
    JLabel countafter(){
        double count = 0;
        JLabel label = new JLabel("折后总计:" + count + "                                                                                                                                             ");
        return label;
    }
}
