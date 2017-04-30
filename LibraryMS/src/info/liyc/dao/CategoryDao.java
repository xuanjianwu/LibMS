package info.liyc.dao;

import java.sql.ResultSet;
import java.util.Vector;

/**
 * Created by liyc on 17-4-26.
 */
public interface CategoryDao {
    int getCategoryId(String category);
    ResultSet getCategoryByAll();
    Vector<String> getCategoryByAllToString();
}
