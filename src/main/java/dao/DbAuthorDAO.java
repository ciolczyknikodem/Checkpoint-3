package dao;

import dao.entry.AuthorEntry;
import dao.entry.BookEntry;
import dao.statements.SQLQueries;
import model.Author;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DbAuthorDAO extends DBConnection implements AuthorDAO {

    public List<Author> getAuthors() {
        List<Author> authors = new ArrayList<>();
        String statement = SQLQueries.getAuthors();

        try {
            PreparedStatement preparedStatement = getPreparedStatement(statement);
            ResultSet result = setUpStatement(preparedStatement);

            while (result.next()) {
                authors.add(new Author(
                        result.getInt(AuthorEntry.author_id.name()),
                        result.getString(AuthorEntry.name.name()),
                        result.getString(AuthorEntry.surname.name()),
                        result.getString(AuthorEntry.brith_year.name()),
                        result.getString(AuthorEntry.city.name()),
                        result.getString(AuthorEntry.country.name())
                        )
                );
            }
        } catch (SQLException e) { System.err.println(e.getClass().getName() + ": " + e.getMessage()); }

        return authors;
    }

    public Map<String, Integer> getAmountOfAuthorBooks() {
        Map<String, Integer> amountOfAuthorsBook = new HashMap<>();
        String statement = SQLQueries.getAmountOfAuthorsBook();

        try {
            PreparedStatement preparedStatement = getPreparedStatement(statement);
            ResultSet result = setUpStatement(preparedStatement);

            while (result.next()) {
                amountOfAuthorsBook.put(
                        result.getString(AuthorEntry.fullname.name()),
                        result.getInt(BookEntry.booksAmount.name())
                );
            }


        } catch (SQLException e) { System.err.println(e.getClass().getName() + ": " + e.getMessage()); }

        return amountOfAuthorsBook;
    }

    public Map<String, String> getInfoAboutAuthors() {
        Map<String, String> authorsInfo = new HashMap<>();
        String statement = SQLQueries.getAuthorsInfo();

        try {
            PreparedStatement preparedStatement = getPreparedStatement(statement);
            ResultSet result = setUpStatement(preparedStatement);

            while (result.next()) {
                authorsInfo.put(
                        result.getString(AuthorEntry.fullname.name()),
                        result.getString(AuthorEntry.brith_year.name())
                );
            }
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + " --> " + e.getMessage());
        }

        return authorsInfo;
    }

}
