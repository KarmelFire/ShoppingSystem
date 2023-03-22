package GUI;

import Utiltool.GuiUtil.getMiddlelocation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * @Author Langxecho
        * @Description //TODO 管理员主界面UI
 * @Date 16:23 2023/3/22
 * @Param
        * @return
        **/
public class AdminUI {
    JScrollPane scro = new JScrollPane();//滚动面板

    Object []columnName = new Object[]{"商品名","剩余数量","出售单价","零售价","商品id","类别"};//表格的字段名
    int numbers = 0;//表示表格中的行数,即有多少商品
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
        //这里是生成表的地方,但是这边的刷新逻辑很复杂,之后要改写,这边就只是暂时用一下子罢了);
        flashtable("null","null","null","null","null","null");
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
            * @Description //TODO 设置表格
     * @Date 17:12 2023/3/22
     * @Param
            * @return
            **/
    JTable settable(String name,String inventory,String soldprice,String importprice,String id,String type){
        //这些形参分别是商品名,剩余数量,出售单价,进价,商品ID,类别
        numbers++;
        Object [][]rowData = new Object[numbers][6];
        JTable table = new JTable(rowData,columnName);
        rowData[numbers - 1][0] = name;
        rowData[numbers - 1][1] = inventory;
        rowData[numbers - 1][2] = soldprice;
        rowData[numbers - 1][3] = importprice;
        rowData[numbers - 1][4] = id;
        rowData[numbers - 1][5] = type;
        return table;
    }
    /*
     * @Author Langxecho
            * @Description //TODO 刷新表格(增加)
     * @Date 18:35 2023/3/22
     * @Param
            * @return
            **/
    JScrollPane flashtable(String name,String inventory,String soldprice,String importprice,String id,String type){
        JTable newly = settable(name,inventory,soldprice,importprice,id,type);
        scro = new JScrollPane(newly);
        scro.setPreferredSize(new Dimension(770,440));
        return scro;
    }
}
