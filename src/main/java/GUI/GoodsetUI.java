package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import Utiltool.GuiUtil.rightMenu;

public class GoodsetUI extends JPanel {
    public GoodsetUI() {
        setLayout(null);

//        表格
        String[] columnName = {"商品", "分类", "价格", "折扣", "库存"};
        String[][] tableValues = {{"农夫山泉", "饮料", "2", "无", "50"}, {"冰红茶", "饮料", "3", "无", "50"}};
        JTable table = new JTable(tableValues, columnName) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table.getTableHeader().setReorderingAllowed(false);   //不可整列移动
        table.getTableHeader().setResizingAllowed(false);   //不可拉动表格

//        滚动
        JScrollPane scrollPane = new JScrollPane(
                table,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
        );
        scrollPane.setBounds(30, 30, 728, 470);
        add(scrollPane);



//        右击菜单
        JPopupMenu menu = new JPopupMenu();
        JMenuItem checkItem = new JMenuItem("查看详情");
        JMenuItem addItem = new JMenuItem("添加购物车");
        JMenuItem buyItem = new JMenuItem("购买商品");
        menu.add(checkItem);
        menu.add(addItem);
        menu.add(buyItem);

        checkItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        addItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        buyItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                  rightMenu.rightMenu(table, e, menu);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {


            }
        });
    }
}
