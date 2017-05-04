package info.liyc.view;

import info.liyc.controller.ToolBarListener;

import javax.swing.*;
import java.awt.*;

/**
 * Created by liyc on 17-4-30.
 */
public class MainFrame extends JFrame {
    public JMenuBar jmb;
    public JMenu jItem, jOperation, jSetting, jHelp;
    public JMenuItem menuOut;
    public QueryPanel qp;
    public TablePanel tp;

    public MainFrame() {
        this.setTitle("图书管理系统");
        tp = new TablePanel();
        qp = new QueryPanel(tp, this);
        this.add(qp, BorderLayout.NORTH);
        this.add(tp, BorderLayout.CENTER);
        jmb = new JMenuBar();

        jItem = new JMenu("快捷菜单");
        jOperation = new JMenu("图书操作");
        jSetting = new JMenu("系统设置");
        jHelp = new JMenu("帮助");

        ToolBarListener tl = new ToolBarListener(this);
        menuOut = new JMenuItem("退出");
        menuOut.addActionListener(tl);
        jItem.add(menuOut);

        jmb.add(jItem);
        jmb.add(jOperation);
        jmb.add(jSetting);
        jmb.add(jHelp);


        this.setJMenuBar(jmb);
        this.setSize(1260, 600);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
