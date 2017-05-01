package info.liyc.dao.impl;

import info.liyc.dao.BookDao;
import info.liyc.vo.Book;

import java.sql.*;

/**
 * Created by liyc on 17-4-25.
 */
public class BookDaoImpl implements BookDao{
    private Connection conn = null;
    private PreparedStatement pstmt = null;

    public BookDaoImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public ResultSet getBooksByAll() {
        try {
            String sql = "SELECT * FROM books";
            this.pstmt = this.conn.prepareStatement(sql);
            ResultSet rs = this.pstmt.executeQuery();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ResultSet getBooksByTitle(String title) {
        try {
            String sql = "SELECT * FROM books WHERE title LIKE '%" + title + "%'";
            this.pstmt = this.conn.prepareStatement(sql);
            ResultSet rs = this.pstmt.executeQuery();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ResultSet getBookByAuthor(String author) {
        try {
            String sql = "SELECT * FROM books WHERE author LIKE '%" + author + "%'";
            this.pstmt = this.conn.prepareStatement(sql);
            ResultSet rs = this.pstmt.executeQuery();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ResultSet getBooksByPublisherId(int publisherId) {
        try {
            String sql = "SELECT * FROM books WHERE publisherId=?";
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setInt(1, publisherId);
            ResultSet rs = this.pstmt.executeQuery();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ResultSet getBooksByPublishDate(String publishDate) {
        try {
            String sql = "SELECT * FROM books WHERE publishDate LIKE '%" + publishDate + "%'";
            this.pstmt = this.conn.prepareStatement(sql);
            ResultSet rs = this.pstmt.executeQuery();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ResultSet getBooksByIsbn(String isbn) {
        try {
            String sql = "SELECT * FROM books WHERE isbn=?";
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setString(1, isbn);
            ResultSet rs = this.pstmt.executeQuery();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ResultSet getBooksByUnitPrice(double unitPrice) {
        try {
            String sql = "SELECT * FROM books WHERE unitPrice=?";
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setDouble(1, unitPrice);
            ResultSet rs = this.pstmt.executeQuery();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ResultSet getBooksByCategoryId(int categortId) {
        try {
            String sql = "SELECT * FROM books WHERE categortId=?";
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setInt(1, categortId);
            ResultSet rs = this.pstmt.executeQuery();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addBook(Book book) {
        try {
            String sql = "INSERT INTO books values (?,?,?,?,?,?,?,?,?,?)";
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setInt(1, book.getId());
            this.pstmt.setString(2, book.getTitle());
            this.pstmt.setString(3, book.getAuthor());
            this.pstmt.setInt(4, book.getPublisherId());
            this.pstmt.setString(5, book.getPublishDate());
            this.pstmt.setString(6, book.getIsbn());
            this.pstmt.setDouble(7, book.getUnitPrice());
            this.pstmt.setString(8, book.getBookDescription());
            this.pstmt.setString(9, book.getAuthorDescription());
            this.pstmt.setInt(10, book.getCategoryId());
            int index = this.pstmt.executeUpdate();
            if (index > 0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public int getMaxId() {
        int id = 0;
        try {
            String sql = "SELECT * FROM books";
            this.pstmt = this.conn.prepareStatement(sql);
            ResultSet rs = this.pstmt.executeQuery();
            if (rs.last())
                id = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public boolean deleteBookById(int id) {
        try {
            String sql = "DELETE FROM books WHERE id=?";
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setInt(1, id);
            int index = this.pstmt.executeUpdate();
            if (index > 0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateBook(Book book) {
        try {
            String sql = "UPDATE books set title=?, author=?, publisherId=?, " +
                    "publishDate=?, isbn=?, unitPrice=?, bookDescription=?, " +
                    "authorDescription=?, categoryId=? WHERE id=?";
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setString(1, book.getTitle());
            this.pstmt.setString(2, book.getAuthor());
            this.pstmt.setInt(3, book.getPublisherId());
            this.pstmt.setString(4, book.getPublishDate());
            this.pstmt.setString(5, book.getIsbn());
            this.pstmt.setDouble(6, book.getUnitPrice());
            this.pstmt.setString(7, book.getBookDescription());
            this.pstmt.setString(8, book.getAuthorDescription());
            this.pstmt.setInt(9, book.getCategoryId());
            this.pstmt.setInt(10, book.getId());
            int index = this.pstmt.executeUpdate();
            if (index > 0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
