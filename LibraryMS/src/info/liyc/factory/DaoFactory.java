package info.liyc.factory;

import info.liyc.dao.AccountDao;
import info.liyc.dao.BookDao;
import info.liyc.dao.proxy.AccountDaoProxy;
import info.liyc.dao.proxy.BookDaoProxy;

/**
 * Created by liyc on 17-4-25.
 */
public class DaoFactory {
    public static AccountDao getAccountDaoInstance() {
        AccountDao dao = null;
        try {
            dao = new AccountDaoProxy();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dao;
    }

    public static BookDao getBookDaoInstance() {
        BookDao dao = null;
        try {
            dao = new BookDaoProxy();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dao;
    }
}
