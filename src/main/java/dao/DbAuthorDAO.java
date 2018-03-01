package dao;

import dao.entry.AuthorEntry;
import dao.statements.SQLQueries;
import model.Author;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
}
