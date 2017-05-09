package by.it.loktev.project.java.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstractDAO {

    int executeCreate(String SQL) throws SQLException {
        try (Connection connection = ConnectorCreator.getConnection();
             Statement statement = connection.createStatement()) {
            if (1 == statement.executeUpdate(SQL, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet keys = statement.getGeneratedKeys();
                if (keys.next()) {
                    return keys.getInt(1);
                }
            }
            return -1;
        }
    }

    int executeUpdate(String SQL) throws SQLException {
        try (Connection connection = ConnectorCreator.getConnection();
             Statement statement = connection.createStatement()) {
            return statement.executeUpdate(SQL);
            }

    }

}
