package info.liyc.dao.proxy;

import info.liyc.dao.CategoryDao;
import info.liyc.dao.impl.CategoryDaoImpl;
import info.liyc.dbc.DatabaseConnection;

import java.sql.ResultSet;
import java.util.Vector;

/**
 * Created by liyc on 17-4-26.
 */
public class CategoryDaoProxy implements CategoryDao {
    private DatabaseConnection dbc = null;
    private CategoryDao dao = null;

    public CategoryDaoProxy() throws Exception {
        try {
            this.dbc = new DatabaseConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.dao = new CategoryDaoImpl(this.dbc.getConnection());
    }

    @Override
    public int getCategoryId(String category) {
        try {
            return this.dao.getCategoryId(category);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 28;
    }

    @Override
    public ResultSet getCategoryByAll() {
        try {
            return this.dao.getCategoryByAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Vector<String> getCategoryByAllToString() {
        try {
            return this.dao.getCategoryByAllToString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
