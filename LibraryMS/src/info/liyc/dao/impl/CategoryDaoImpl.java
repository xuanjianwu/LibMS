package info.liyc.dao.impl;

import info.liyc.dao.CategoryDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

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
    public int getCategoryId(String category) {
        int categoryId = 7;
        try {
            String sql = "SELECT * FROM categories WHERE category=?";
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
    public ResultSet getCategoryByAll() {
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

    @Override
    public Vector<String> getCategoryByAllToString() {
        Vector<String> rsv = new Vector<String>();
        try {
            String sql = "SELECT * FROM categories";
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next())
                rsv.add(rs.getString(2));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rsv;
    }
}
