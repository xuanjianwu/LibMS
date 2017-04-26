package info.liyc.dao.proxy;

import info.liyc.dao.BookDao;
import info.liyc.dao.impl.BookDaoImpl;
import info.liyc.dbc.DatabaseConnection;
import info.liyc.vo.Book;

import java.sql.ResultSet;

/**
 * Created by liyc on 17-4-26.
 */
public class BookDaoProxy implements BookDao {
    private DatabaseConnection dbc = null;
    private BookDao dao = null;

    public BookDaoProxy() throws Exception {
        try {
            this.dbc = new DatabaseConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.dao = new BookDaoImpl(this.dbc.getConnection());
    }

    @Override
    public ResultSet getBooksByAll() throws Exception {
        try {
            return this.dao.getBooksByAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ResultSet getBooksByTitle(String title) throws Exception {
        try {
            return this.dao.getBooksByTitle(title);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ResultSet getBookByAuthor(String author) throws Exception {
        try {
            return this.dao.getBookByAuthor(author);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ResultSet getBooksByPublisherId(int publisherId) throws Exception {
        try {
            return this.dao.getBooksByPublisherId(publisherId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ResultSet getBooksByPublishDate(String publishDate) throws Exception {
        try {
            return this.dao.getBooksByPublishDate(publishDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ResultSet getBooksByIsbn(String isbn) throws Exception {
        try {
            return this.dao.getBooksByIsbn(isbn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ResultSet getBooksByUnitPrice(double unitPrice) throws Exception {
        try {
            return this.dao.getBooksByUnitPrice(unitPrice);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ResultSet getBooksByCategoryId(int categortId) throws Exception {
        try {
            return this.dao.getBooksByCategoryId(categortId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addBook(Book book) throws Exception {
        try {
            return this.dao.addBook(book);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public int getMaxId() throws Exception {
        try {
            return this.dao.getMaxId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public boolean deleteBookById(int id) throws Exception {
        try {
            return this.dao.deleteBookById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateBook(Book book) throws Exception {
        try {
            return this.dao.updateBook(book);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public int getCategoryId(String category) throws Exception {
        try {
            return this.dao.getCategoryId(category);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 28;
    }

    @Override
    public int getPublisherId(String publisher) throws Exception {
        try {
            return this.dao.getPublisherId(publisher);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 4;
    }
}
