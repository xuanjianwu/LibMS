package info.liyc.dao.impl;

import info.liyc.dao.AccountDao;
import info.liyc.vo.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by liyc on 17-4-25.
 */
public class AccountDaoImpl implements AccountDao {
    private Connection conn = null;
    private PreparedStatement pstmt = null;

    public AccountDaoImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public boolean doLogin(Account account) throws Exception {
        boolean flag = false;
        try {
            String sql = "SELECT * FROM accounts WHERE loginId=? AND loginPwd=?";
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setString(1, account.getLoginId());
            this.pstmt.setString(2,account.getLoginPwd());
            ResultSet rs = this.pstmt.executeQuery();
            if (rs.next()) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
}
