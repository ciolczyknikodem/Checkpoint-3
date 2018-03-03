package dao;

import model.Book;

import java.sql.SQLDataException;
import java.util.List;

public interface BookDAO {
    List<String> getAllBookTitles();
    List<Book> getAllBooks() throws SQLDataException;
    List<Book> getBookBy(String searchPhrase);
    List<Book> getBookBy(int authorId);
    void add(Book book);
    void deleteBookBy(Long ISBN);
}
