package dao;

import dao.entry.PublisherEntry;
import dao.statements.SQLQueries;
import model.Publisher;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DbPublisherDAO extends DBConnection implements PublisherDAO  {

    public List<Publisher> getPublishers() {
        List<Publisher> publishers = new ArrayList<>();
        String statement = SQLQueries.getPublishers();

        try {
            PreparedStatement preparedStatement = getPreparedStatement(statement);
            ResultSet result = setUpStatement(preparedStatement);

            while (result.next()) {

                publishers.add(new Publisher(
                        result.getString(PublisherEntry.publisher_id.name()),
                        result.getString(PublisherEntry.name.name()),
                        result.getString(PublisherEntry.city.name()),
                        result.getString(PublisherEntry.country.name())
                ));
            }
            result.close();

        } catch (SQLException e) { System.err.println(e.getClass().getName() + " --> " + e.getMessage());
        } finally { closeConnection(); }

        return publishers;
    }
}
