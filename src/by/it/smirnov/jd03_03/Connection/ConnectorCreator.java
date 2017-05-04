package by.it.smirnov.jd03_03.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectorCreator {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }
    }

    private static volatile Connection connection = null;

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            synchronized (ConnectionInfo.URL_DB) {
                if (connection == null || connection.isClosed())
                    connection = DriverManager.getConnection(
                            ConnectionInfo.URL_DB,
                            ConnectionInfo.USER_DB,
                            ConnectionInfo.PASSWORD_DB
                    );
            }
        }
        return connection;
    }
}
