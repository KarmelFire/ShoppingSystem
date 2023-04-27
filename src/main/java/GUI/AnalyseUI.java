package GUI;

import Utiltool.GuiUtil.getMiddlelocation;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class AnalyseUI {
    JFrame window = new JFrame("数据分析");//数据分析窗口
    JButton back = new JButton("返回");//返回按钮
    JButton print = new JButton("打印报表");//打印报表按钮
    SpinnerDateModel model = new SpinnerDateModel();
    JSpinner yeartext = new JSpinner(model);//年日期获取框
    JSpinner monthtext = new JSpinner(model);//月份获取
    JButton monthreport = new JButton("月度报表");//月度报表按钮
    JButton yearreport = new JButton("年度报表");//年度报表按钮
    JButton yearsure = new JButton("确定");//年份确定按钮
    JButton monthsure = new JButton("确定");//月份确定按钮
    JTable information = new JTable();//左边表格
    JTable typeinformation = new JTable();//右边表格
    JFrame analyseWindow(){
        //窗口属性设置
        window.setSize(800,600);
        int a[] = getMiddlelocation.getMiddlelocate(window);
        window.setLocation(a[0],a[1]);
        window.setLayout(new FlowLayout(FlowLayout.LEFT));
        //占位符设置
//        JLabel ss = new JLabel("                                                                                                                                                                                                                             ");
//        window.add(ss);
        //窗口第一行组件设置
        //spinner日期模式实例设置
        yeartext.setPreferredSize(new Dimension(90,25));
        JLabel guidang = new JLabel("        归档:    年份:   ");
        yeartext.setValue(new Date());
        JSpinner.DateEditor editor = new JSpinner.DateEditor(yeartext,"yyyy");//"yyyy-MM-dd HH:mm:ss"
        yeartext.setEditor(editor);
        JLabel month = new JLabel("月份:   ");
        monthtext.setPreferredSize(new Dimension(90,25));
        editor = new JSpinner.DateEditor(monthtext,"MM");
        monthtext.setEditor(editor);
        window.add(guidang);
        window.add(yeartext);
        window.add(month);
        window.add(monthtext);
        //------------------------------------------------------------------------------------
        JLabel yuefen = new JLabel("月份:   ");
//        monthtext.setSize(80,25);
        JLabel sss = new JLabel("                                                  ");
        monthreport.setSize(80,25);
        yearreport.setSize(80,25);

        window.add(sss);
        window.add(monthreport);
        window.add(yearreport);
        //存放两个表格面板的主面板
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(776,450));
        panel.setBackground(Color.BLUE);
        //上表格(年或者月的总体)
        window.add(panel);
        window.setVisible(true);
        return window;
    }


}
