package info.liyc.view;

import info.liyc.controller.LoginListener;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Lyc on 2017/4/28.
 */
public class LoginPanel extends JPanel{
    JLabel lbeId, lbePassword;
    public JTextField txtId;
    public JPasswordField txtPass;
    public JButton btnLogin, btnCancel;

    public LoginPanel(LoginFrame lf) {
        lbeId = new JLabel("用户");
        lbePassword = new JLabel("密码");
        txtId = new JTextField(15);
        txtPass = new JPasswordField(15);
        txtPass.setEchoChar('*');
        btnLogin = new JButton("登录");
        btnCancel = new JButton("取消");

        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();

        LoginListener ll = new LoginListener(lf, this);
        btnLogin.addActionListener(ll);
        btnCancel.addActionListener(ll);

        this.setLayout(gbl);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbl.setConstraints(lbeId, gbc);
        this.add(lbeId);

        gbc.gridx = 2;
        gbc.gridy = 1;
        gbl.setConstraints(txtId, gbc);
        this.add(txtId);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbl.setConstraints(lbePassword, gbc);
        this.add(lbePassword);

        gbc.gridx = 2;
        gbc.gridy = 2;
        gbl.setConstraints(txtPass, gbc);
        this.add(txtPass);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbl.setConstraints(btnLogin, gbc);
        this.add(btnLogin);

        gbc.gridx = 2;
        gbc.gridy = 3;
        gbl.setConstraints(btnCancel, gbc);
        this.add(btnCancel);
    }
}
