package GUI;

import Utiltool.GuiUtil.getMiddlelocation;
import Utiltool.dbUtil.dbUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
 * @Author Langxecho
        * @Description //TODO 管理员主界面UI
 * @Date 16:23 2023/3/22
 * @Param
        * @return
        **/
public class AdminUI {
    JScrollPane scro;//滚动面板
    Object []columnName = new Object[]{"商品名","剩余数量","出售单价","零售价","商品id","类别"};//表格的字段名
    JFrame admin = new JFrame("管理员界面");//管理员界面主界面
    String user;//当前管理员的用户名
    String empty = "                                                                                                                                                                                                                             ";
    String empty1 = "                                                                                                                                                                                                                                                                                                                                                                             ";
    JLabel emptysmall = new JLabel(empty);//小占位符
    JLabel lable = new JLabel(empty1);//占位符,占用一整行
    JButton addgoods = new JButton("增加商品");//增加商品按钮
    JButton delgoods = new JButton("删除商品");//删除商品按钮
    JButton searchgoods = new JButton("查找商品");//查找商品按钮
    JButton exit = new JButton("退出");//退出系统按钮
    JButton managergood = new JButton("数据分析");//数据分析按钮
    JButton backup = new JButton("备份与恢复");//数据备份与回复按钮
    JFrame generateadmin(){
        admin.setSize(800,600);
        JLabel welcome = new JLabel("欢迎管理员：" + user + empty);
        admin.add(welcome);
        FlowLayout ss = new FlowLayout(FlowLayout.LEFT);
        admin.setLayout(ss);
        admin.add(lable);//添加占位符,这里占用掉两行
        admin.add(lable);//添加占位符,这里占用掉两行
        int a[] = getMiddlelocation.getMiddlelocate(admin);
        admin.setLocation(a[0],a[1]);
        //添加按钮
        initbotton();
        admin.add(addgoods);
        admin.add(delgoods);
        admin.add(searchgoods);
//        admin.add(emptysmall);
        //占位面板中的表格

        //外层滚动面板
        //生成表
        try {
            scro = new JScrollPane(inittable());//滚动面板
            scro.setPreferredSize(new Dimension(770,440));
            System.out.println("表格初始化成功");
        } catch (Exception e) {
            System.out.println("表格初始化失败");
            e.printStackTrace();
        }
        //----------------
        admin.add(scro);
        admin.add(managergood);
        admin.add(backup);
        admin.add(exit);
        admin.setVisible(true);
        return admin;
    }
    /*
     * @Author Langxecho
            * @Description //TODO 初始化所有按钮(设置外观与监听器)
     * @Date 16:31 2023/3/22
     * @Param
            * @return
            **/
    void initbotton(){
        //添加商品按钮
        addgoods.setSize(60,20);
        addgoods.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //设置操作
            }
        });
        //删除商品按钮
        delgoods.setSize(60,20);
        delgoods.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                设置操作
            }
        });
        //查找商品按钮
        searchgoods.setSize(60,20);
        searchgoods.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                设置操作
            }
        });
        //退出系统按钮
        exit.setSize(60,20);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                设置操作
                System.exit(0);
            }
        });
        //管理系统按钮
        managergood.setSize(60,20);
        managergood.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //设置操作
            }
        });
        //备份与恢复按钮
        backup.setSize(60,20);
        backup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //设置操作
            }
        });

    }
    /*
     * @Author Langxecho
            * @Description //TODO 设初始化b表格
     * @Date 17:12 2023/3/22
     * @Param
            * @return
            **/
    JTable inittable() throws Exception {
        //加载数据库
        String sql = "Select * from goods";
        dbUtil db = new dbUtil();
        Connection con = db.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = pstmt.executeQuery();
        //获取记录行数
        rs.last();
        int numbers = rs.getRow();
        System.out.println("检索到了" + numbers + "数据");
        rs.beforeFirst();//指针归位
        //表格相关设置
        Object [][]rowData = new Object[numbers][6];
        while (rs.next()){
            rowData[rs.getRow() - 1][0] = rs.getString("id");
            rowData[rs.getRow() - 1][1] = rs.getString("discount");
            rowData[rs.getRow() - 1][2] = rs.getString("price");
            rowData[rs.getRow() - 1][3] = rs.getString("store");
            rowData[rs.getRow() - 1][4] = rs.getString("category");
            rowData[rs.getRow() - 1][5] = rs.getString("portprice");
        }
        JTable table = new JTable(rowData,columnName);
        db.closeConnection(con);
        return table;
    }

}
