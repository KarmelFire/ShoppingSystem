package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Utiltool.GuiUtil.rightMenu;
import Utiltool.dbUtil.dbUtil;

public class GoodsetUI extends JPanel {
    JTable table;
    public GoodsetUI() {
        setLayout(null);

//        表格
        String[] columnName = {"商品", "分类", "价格", "折扣", "库存"};
        //加载数据库
        String sql = "select * from goods";
        dbUtil db =new dbUtil();
        Connection con;
        PreparedStatement pstmt;
        ResultSet rs;
        String[][] tableValues;

        try {
            con = db.getConnection();
            pstmt = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = pstmt.executeQuery();
            //查找数据条数
            rs.last();
            int rownumber = rs.getRow();
            rs.beforeFirst();//指针归位
            tableValues = new String[rownumber][5];//表格的行列设置
            while (rs.next()){
                tableValues[rs.getRow() - 1][0] = rs.getString("name");
                tableValues[rs.getRow() - 1][1] = rs.getString("category");
                tableValues[rs.getRow() - 1][2] = rs.getString("price");
                tableValues[rs.getRow() - 1][3] = rs.getString("discount");
                tableValues[rs.getRow() - 1][4] = rs.getString("store");
                table = new JTable(tableValues, columnName) {
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                };
            }
            System.out.println("表格数据加载成功");
        }catch (Exception e){
            System.out.println("表格数据加载失败");
            e.printStackTrace();
        }


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
                BuyUI.showBuy();
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
