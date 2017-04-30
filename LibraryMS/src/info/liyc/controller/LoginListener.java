package info.liyc.controller;

import info.liyc.factory.DaoFactory;
import info.liyc.view.LoginFrame;
import info.liyc.view.LoginPanel;
import info.liyc.view.MainFrame;
import info.liyc.vo.Account;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Lyc on 2017/4/28.
 */
public class LoginListener implements ActionListener {
    LoginFrame lf;
    LoginPanel lp;

    public LoginListener(LoginFrame lf, LoginPanel lp) {
        this.lf = lf;
        this.lp = lp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btnTemp = (JButton) e.getSource();
        if (btnTemp == lp.btnLogin) {
            String id = lp.txtId.getText();
            String pass = String.valueOf(lp.txtPass.getPassword());
            Account ac = new Account();
            ac.setLoginId(id);
            ac.setLoginPwd(pass);
            if (DaoFactory.getAccountDaoInstance().doLogin(ac)) {
                //System.out.println("Successful Login");
                MainFrame mf = new MainFrame();
                lf.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "登录失败");
            }
        } else if (btnTemp == lp.btnCancel) {
            lp.txtId.setText("");
            lp.txtPass.setText("");
        }
    }
}
