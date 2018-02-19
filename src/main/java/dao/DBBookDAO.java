package dao;

import dao.entry.BookEntry;
import dao.statements.sqlQueries;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBBookDAO implements BookDAO {
    DBProcess process = new DBProcess();

    public List<String> getAllBookTitles() {
        List<String> bookTitles = new ArrayList<String>();
        String statement = sqlQueries.showBooks();

        try {
            ResultSet result = process.executeDisplay(statement);

            while (result.next()) {
                String title = result.getString(BookEntry.title.name());
                bookTitles.add(title);
            }
            result.close();
        }
        catch (SQLException e) { System.err.println(e.getClass().getName() + ": " + e.getMessage()); }

        return bookTitles;
    }
}
