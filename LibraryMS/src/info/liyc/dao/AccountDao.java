package info.liyc.dao;

import info.liyc.vo.Account;

/**
 * Created by liyc on 17-4-25.
 */
public interface AccountDao {
    public boolean doLogin(Account account) throws Exception;
}
