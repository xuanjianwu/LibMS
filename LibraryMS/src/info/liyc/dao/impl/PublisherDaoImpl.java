package info.liyc.dao.impl;

import info.liyc.dao.PublisherDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by liyc on 17-4-26.
 */
public class PublisherDaoImpl implements PublisherDao {
    private Connection conn = null;
    private PreparedStatement pstmt = null;

    public PublisherDaoImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public int getPublisherId(String publisher) throws Exception {
        int id = 4;
        try {
            String sql = "SELECT * FROM publishers WHERE name=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, publisher);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next())
                id = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
}
