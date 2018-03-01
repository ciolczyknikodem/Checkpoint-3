package dao;

import dao.entry.BookEntry;
import dao.statements.SQLQueries;
import model.Book;

import javax.swing.text.html.HTMLDocument;
import java.sql.*;
import java.util.ArrayList;

import java.util.List;

public class DbBookDAO extends DBConnection implements BookDAO {

    public List<String> getAllBookTitles() {
        List<String> bookTitles = new ArrayList<>();
        String statement = SQLQueries.getBookTitles();

        try {
            PreparedStatement preparedStatement = getPreparedStatement(statement);
            ResultSet result = setUpStatement(preparedStatement);

            while (result.next()) {
                String title = result.getString(BookEntry.title.name());
                bookTitles.add(title);
            }
            result.close();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }

        return bookTitles;
    }

    public List<Book> getAllBooks() throws SQLDataException {
        List<Book> books = new ArrayList<>();
        String statement = SQLQueries.getBooks();

        try {
            PreparedStatement preparedStatement = getPreparedStatement(statement);
            ResultSet result = setUpStatement(preparedStatement);

            while(result.next()) {
                books.add(new Book(

                        result.getLong(BookEntry.ISBN.name()),
                        result.getInt(BookEntry.author.name()),
                        result.getString(BookEntry.title.name()),
                        result.getString(BookEntry.publisher.name()),
                        result.getInt(BookEntry.publication_year.name()),
                        result.getInt(BookEntry.price.name()),
                        result.getInt(BookEntry.type.name())
                ));
            }
            return books;

        } catch (SQLException e) { System.err.println(e.getClass().getName() + " --> " + e.getMessage()); }

        throw new SQLDataException();
    }

    public void add(Book book) {
        String statement = SQLQueries.add();

        try {
            PreparedStatement preparedStatement = getPreparedStatement(statement);

            preparedStatement.setLong(1, book.getISBN());
            preparedStatement.setInt(2, book.getAuthor());
            preparedStatement.setString(3, book.getTitle());
            preparedStatement.setString(4, book.getPublisher());
            preparedStatement.setInt(5, book.getPublicationYear());
            preparedStatement.setInt(6, book.getPrice());
            preparedStatement.setInt(7, book.getType());

            update(preparedStatement);


        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + " --> " + e.getMessage());
        }
    }

    public void deleteBookBy(Long ISBN) {
        String statement = SQLQueries.deleteBook();

        try {
            PreparedStatement preparedStatement = getPreparedStatement(statement);
            preparedStatement.setLong(1, ISBN);
            update(preparedStatement);

        } catch (SQLException e) { System.err.println(e.getClass().getName() + " --> " + e.getMessage()); }
    }
}