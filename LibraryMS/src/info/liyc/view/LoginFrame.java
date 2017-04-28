package info.liyc.view;

import javax.swing.*;

/**
 * Created by Lyc on 2017/4/28.
 */
public class LoginFrame extends JFrame {
    LoginPanel lp;

    public LoginFrame() {
        this.setTitle("图书管理系统");
        lp = new LoginPanel(this);
        this.getContentPane().add(lp);
        this.setSize(500, 300);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
