package info.liyc.dao;

import java.sql.ResultSet;

/**
 * Created by liyc on 17-4-26.
 */
public interface CategoryDao {
    int getCategoryId(String category) throws Exception;
    ResultSet getCategoryByAll() throws Exception;
}
