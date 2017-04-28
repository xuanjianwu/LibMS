package info.liyc.dao;

import info.liyc.vo.Book;

import java.security.interfaces.RSAKey;
import java.sql.ResultSet;
import java.sql.Struct;

/**
 * Created by liyc on 17-4-25.
 */
public interface BookDao {
    ResultSet getBooksByAll();
    ResultSet getBooksByTitle(String title);
    ResultSet getBookByAuthor(String author);
    ResultSet getBooksByPublisherId(int publisherId);
    ResultSet getBooksByPublishDate(String publishDate);
    ResultSet getBooksByIsbn(String isbn);
    ResultSet getBooksByUnitPrice(double unitPrice);
    ResultSet getBooksByCategoryId(int categortId);

    boolean addBook(Book book);
    int getMaxId();
    boolean deleteBookById(int id);
    boolean updateBook(Book book);
}
