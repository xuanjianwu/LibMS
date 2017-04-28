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
    public int getPublisherId(String publisher) {
        int publisherId = 4;
        try {
            String sql = "SELECT * FROM publishers WHERE name=?";
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setString(1, publisher);
            ResultSet rs = this.pstmt.executeQuery();
            if (rs.next())
                publisherId = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return publisherId;
    }

    @Override
    public ResultSet getPublisherByAll() {
        try {
            String sql = "SELECT * FROM publishers";
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
