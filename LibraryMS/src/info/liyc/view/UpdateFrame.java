package info.liyc.view;

import info.liyc.controller.QueryListener;

import javax.swing.*;
import java.util.Vector;

/**
 * Created by Lyc on 2017/5/1.
 */
public class UpdateFrame extends JFrame {
    UpdatePanel up;

    public UpdateFrame(Vector<String> updateV) {
        this.setTitle("图书管理系统");
        up = new UpdatePanel(this, updateV);
        this.getContentPane().add(up);
        this.setSize(1260,600);
        this.setVisible(true);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
