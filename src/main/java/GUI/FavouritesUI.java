package GUI;

import Utiltool.dbUtil.dbUtil;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FavouritesUI extends JPanel {
    String empty1 = "                                                                                                                                                                                                                                                                                                                                                                             ";
    Double finallypay = 0.0;

    int goodid[];//商品id
    JTable table;
    int buynumber[];//用户选择的购买数量
    String goodname;//商品名
    String store;//商品存量
    int rownumber;//购物车中储存商品的数量
    public FavouritesUI(String getuser) {
        setLayout(null);

//        表格
        String[] colunmName = {"商品", "库存", "购买数量","价格(元)"};
        String[][] tableValues;
        //设置数据库表格
        dbUtil db = new dbUtil();
        String sql1 = "select * from user where username = ?";
        try {
            Connection con = db.getConnection();
            PreparedStatement pre = con.prepareStatement(sql1,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            pre.setString(1,getuser);
            ResultSet rs = pre.executeQuery();
            rs.next();
            //得到用户的id
            String userid = rs.getString("id");
            //查询购物车中的数据
            String sql2 = "select * from favourites where uesrid = ?";
            pre = con.prepareStatement(sql2,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            pre.setString(1,userid);
            ResultSet re =  pre.executeQuery();
            //获取购物车中不同商品的数量
            re.last();
            rownumber = re.getRow();
            re.beforeFirst();//指针归位
            tableValues = new String[rownumber][4];
            goodid = new int[rownumber];
            buynumber = new int[rownumber];

            while (re.next()){
                goodid[re.getRow() - 1] = re.getInt("goodid");
                buynumber[re.getRow() - 1] = re.getInt("buynumber");
                tableValues[re.getRow() - 1][2] = String.valueOf(re.getInt("buynumber"));
            }
            //取得剩余的三个商品数据
            String sql3 = "select * from goods where id = ?";
            ResultSet re1;
            pre = con.prepareStatement(sql3,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            for(int i = 0;i < rownumber;i++){
                pre.setInt(1,goodid[i]);
                re1 = pre.executeQuery();
                re1.next();
                tableValues[i][0] = re1.getString("name");
                tableValues[i][1] = re1.getString("store");
                tableValues[i][3] = String.valueOf((re1.getDouble("price") * buynumber[i]));
                finallypay += re1.getDouble("price") * buynumber[i];
                table = new JTable(tableValues, colunmName) {
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                };
                table.getTableHeader().setReorderingAllowed(false);   //不可整列移动
                table.getTableHeader().setResizingAllowed(false);   //不可拉动表格
                System.out.println("表格加载成功");
            }

        } catch (Exception e) {
            System.out.println("收藏夹表格加载失败");
            e.printStackTrace();
        }

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
