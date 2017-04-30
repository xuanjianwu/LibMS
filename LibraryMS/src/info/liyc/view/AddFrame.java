package info.liyc.view;

import javax.swing.*;

/**
 * Created by liyc on 17-4-30.
 */
public class AddFrame extends JFrame {
    AddPanel ap;

    public AddFrame() {
        this.setTitle("图书管理系统");
        ap = new AddPanel(this);
        this.getContentPane().add(ap);
        this.setSize(1260,600);
        this.setVisible(true);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
