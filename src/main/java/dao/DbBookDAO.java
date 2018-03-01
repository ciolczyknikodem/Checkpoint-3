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
        String statement = SQLQueries.showBooks();

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
}