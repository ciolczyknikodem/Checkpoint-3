package dao;

import org.sqlite.SQLiteConfig;

import java.sql.*;

class DBConnection {

    private static final String DB_LOCATION = "jdbc:sqlite:src/main/java/database/data.db";
    private static final String DRIVER = "org.sqlite.JDBC";
    private Connection connection;

    private void makeConnection() throws SQLException {
        try {
            SQLiteConfig config = new SQLiteConfig();
            config.enforceForeignKeys(true);
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(DB_LOCATION, config.toProperties());

        } catch (ClassNotFoundException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    protected void closeConnection() {

        if (connection != null) {
            try {
                connection.close();

            } catch (SQLException e) {
                System.err.println("Connection hasn\'t been closed properly.");
            }
        }
    }

    PreparedStatement getPreparedStatement(String statement) throws SQLException {
        makeConnection();
        return connection.prepareStatement(statement);
    }

    ResultSet setUpStatement(PreparedStatement statement) throws SQLException {
        return statement.executeQuery();
    }

    boolean update(PreparedStatement statement) {

        try {
            makeConnection();
            connection.setAutoCommit(false);
            statement.executeUpdate();
            connection.commit();
            return true;

        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + " --> " + e.getMessage());

        } finally {
            closeConnection();
        }
        return false;
    }
}


