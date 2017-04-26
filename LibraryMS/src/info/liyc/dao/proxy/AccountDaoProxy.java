package info.liyc.dao.proxy;

import info.liyc.dao.AccountDao;
import info.liyc.dao.impl.AccountDaoImpl;
import info.liyc.dbc.DatabaseConnection;
import info.liyc.vo.Account;

import java.sql.SQLException;

/**
 * Created by liyc on 17-4-26.
 */
public class AccountDaoProxy implements AccountDao {
    private DatabaseConnection dbc = null;
    private AccountDao dao = null;

    public AccountDaoProxy() throws Exception {
        try {
            this.dbc = new DatabaseConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.dao = new AccountDaoImpl(this.dbc.getConnection());
    }

    @Override
    public boolean doLogin(Account account) throws Exception {
        boolean flag = false;
        try {
            flag = this.dao.doLogin(account);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.dbc.close();
        }
        return flag;
    }
}
