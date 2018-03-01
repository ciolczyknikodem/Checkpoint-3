package dao;

import model.Book;

import java.sql.SQLDataException;
import java.util.List;

public interface BookDAO {
    List<String> getAllBookTitles();
    List<Book> getAllBooks() throws SQLDataException;
    void add(Book book);
    void deleteBookBy(Long ISBN);
}
