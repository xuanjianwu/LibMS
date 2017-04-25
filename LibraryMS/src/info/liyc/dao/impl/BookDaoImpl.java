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
    public ResultSet getBooksByAll() throws Exception {
        try {
            String sql = "SELECT * FROM books";
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ResultSet getBooksByTitle(String title) throws Exception {
        try {
            String sql = "SELECT * FROM books WHERE title LIKE '%" + title + "%'";
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ResultSet getBookByAuthor(String author) throws Exception {
        try {
            String sql = "SELECT * FROM books WHERE author LIKE '%" + author + "%'";
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ResultSet getBooksByPublisherId(int publisherId) throws Exception {
        try {
            String sql = "SELECT * FROM books WHERE publisherId=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, publisherId);
            ResultSet rs = pstmt.executeQuery();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ResultSet getBooksByPublishDate(String publishDate) throws Exception {
        try {
            String sql = "SELECT * FROM books WHERE publishDate LIKE '%" + publishDate + "%'";
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ResultSet getBooksByIsbn(String isbn) throws Exception {
        try {
            String sql = "SELECT * FROM books WHERE isbn=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, isbn);
            ResultSet rs = pstmt.executeQuery();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ResultSet getBooksByUnitPrice(double unitPrice) throws Exception {
        try {
            String sql = "SELECT * FROM books WHERE unitPrice=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setDouble(1, unitPrice);
            ResultSet rs = pstmt.executeQuery();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ResultSet getBooksByCategoryId(int categortId) throws Exception {
        try {
            String sql = "SELECT * FROM books WHERE categortId=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, categortId);
            ResultSet rs = pstmt.executeQuery();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addBook(Book book) throws Exception {
        try {
            String sql = "INSERT INTO books values (?,?,?,?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, book.getId());
            pstmt.setString(2, book.getTitle());
            pstmt.setString(3, book.getAuthor());
            pstmt.setInt(4, book.getPublisherId());
            pstmt.setString(5, book.getPublishDate());
            pstmt.setString(6, book.getIsbn());
            pstmt.setDouble(7, book.getUnitPrice());
            pstmt.setString(8, book.getBookDescription());
            pstmt.setString(9, book.getAuthorDescription());
            pstmt.setInt(10, book.getCategoryId());
            int index = pstmt.executeUpdate();
            if (index > 0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public int getMaxId() throws Exception {
        int id = 1;
        try {
            String sql = "SELECT * FROM books";
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            if (rs.last())
                id = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public boolean deleteBookById(int id) throws Exception {
        try {
            String sql = "DELETE FROM books WHERE id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            int index = pstmt.executeUpdate();
            if (index > 0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateBook(Book book) throws Exception {
        try {
            String sql = "UPDATE books set title=?, author=? publisherId=?, " +
                    "publishDate=?, isbn=?, unitPrice=?, bookDescription=?, " +
                    "authorDescription=?, categoryId=? WHERE id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, book.getTitle());
            pstmt.setString(2, book.getAuthor());
            pstmt.setInt(3, book.getPublisherId());
            pstmt.setString(4, book.getPublishDate());
            pstmt.setString(5, book.getIsbn());
            pstmt.setDouble(6, book.getUnitPrice());
            pstmt.setString(7, book.getBookDescription());
            pstmt.setString(8, book.getAuthorDescription());
            pstmt.setInt(9, book.getCategoryId());
            pstmt.setInt(10, book.getId());
            int index = pstmt.executeUpdate();
            if (index > 0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public int getCategoryId(String category) throws Exception {
        int categoryId = 28;
        try {
            String sql = "SELECT * FROM categories WHERE name=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, category);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next())
                categoryId = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryId;
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
