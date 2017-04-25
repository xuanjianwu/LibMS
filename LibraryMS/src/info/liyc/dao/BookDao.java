package info.liyc.dao;

import info.liyc.vo.Book;

import java.security.interfaces.RSAKey;
import java.sql.ResultSet;
import java.sql.Struct;

/**
 * Created by liyc on 17-4-25.
 */
public interface BookDao {
    ResultSet getBooksByAll() throws Exception;
    ResultSet getBooksByTitle(String title) throws Exception;
    ResultSet getBookByAuthor(String author) throws Exception;
    ResultSet getBooksByPublisherId(int publisherId) throws Exception;
    ResultSet getBooksByPublishDate(String publishDate) throws Exception;
    ResultSet getBooksByIsbn(String isbn) throws Exception;
    ResultSet getBooksByUnitPrice(double unitPrice) throws Exception;
    ResultSet getBooksByCategoryId(int categortId) throws Exception;

    boolean addBook(Book book) throws Exception;
    int getMaxId() throws Exception;
    boolean deleteBookById(int id) throws Exception;
    boolean updateBook(Book book) throws Exception;
    int getCategoryId(String category) throws Exception;
    int getPublisherId(String publisher) throws Exception;
}
