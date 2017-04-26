package info.liyc.dao.impl;

import info.liyc.dao.CategoryDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by liyc on 17-4-26.
 */
public class CategoryDaoImpl implements CategoryDao {
    private Connection conn = null;
    private PreparedStatement pstmt = null;

    public CategoryDaoImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public int getCategoryId(String category) throws Exception {
        int categoryId = 28;
        try {
            String sql = "SELECT * FROM categories WHERE name=?";
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setString(1, category);
            ResultSet rs = this.pstmt.executeQuery();
            if (rs.next())
                categoryId = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryId;
    }

    @Override
    public ResultSet getCategoryByAll() throws Exception {
        try {
            String sql = "SELECT * FROM categories";
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
