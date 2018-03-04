package dao;

import dao.entry.BookEntry;
import dao.statements.SQLQueries;
import model.Book;

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
        String statement = SQLQueries.getBooks();

        try {
            PreparedStatement preparedStatement = getPreparedStatement(statement);
            return executeResultSet(preparedStatement);

        } catch (SQLException e) { System.err.println(e.getClass().getName() + " --> " + e.getMessage()); }

        throw new SQLDataException();
    }

    public List<Book> getBookBy(String searchPhrase) {
        String statement = SQLQueries.getBooksBySearchPhrase();

        try {
            PreparedStatement preparedStatement = getPreparedStatement(statement);
            preparedStatement = setValuesForPreparedStatement(preparedStatement, searchPhrase);

            return executeResultSet(preparedStatement);

        } catch (SQLException e) { System.err.println(e.getClass().getName() + " --> " + e.getMessage()); }

        return null;
    }

    private PreparedStatement setValuesForPreparedStatement(PreparedStatement statement, String searchPhrase) throws SQLException {
        for (int i=1; i<5; ++i) {
            statement.setString(i, "%" + searchPhrase + "%");
        }
        return statement;
    }

    private List<Book> executeResultSet(PreparedStatement statement) throws SQLException {
        ResultSet resultSet = setUpStatement(statement);
        List<Book> books = new ArrayList<>();

        while(resultSet.next()) {
            books.add(new Book(

                    resultSet.getLong(BookEntry.ISBN.name()),
                    resultSet.getInt(BookEntry.author.name()),
                    resultSet.getString(BookEntry.title.name()),
                    resultSet.getString(BookEntry.publisher.name()),
                    resultSet.getInt(BookEntry.publication_year.name()),
                    resultSet.getInt(BookEntry.price.name()),
                    resultSet.getInt(BookEntry.type.name())
                ));
        }
        return books;
    }

    public List<Book> getBookBy(int authorId) {
        String statement = SQLQueries.getBooksByAuthor();

        try {
            PreparedStatement preparedStatement = getPreparedStatement(statement);
            preparedStatement.setInt(1, authorId);
            return executeResultSet(preparedStatement);


        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + " --> " + e.getMessage());
        }
        return null;
    }

    public List<Book> getBookFromLastTenYears() {
        String statement = SQLQueries.getBooksFromLastTenYears();

        try {
            PreparedStatement preparedStatement = getPreparedStatement(statement);
            return executeResultSet(preparedStatement);


        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + " --> " + e.getMessage());
        }
        return null;
    }

    public List<Book> getMostExpensiveBook() {
        String statement = SQLQueries.getMostExpensiveBook();

        try {
            PreparedStatement preparedStatement = getPreparedStatement(statement);
            return executeResultSet(preparedStatement);

        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + " --> " + e.getMessage());
        }
        return null;
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