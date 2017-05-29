package by.it.ikavalenka.project.java.dao;

import by.it.ikavalenka.jd03_03.DAO.Connect;
import by.it.ikavalenka.project.java.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by USER on 03.05.2017.
 */
public abstract class AbstractDAO {
    int executeCreate(String sql) throws SQLException {

        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet keys = statement.getGeneratedKeys();
                if (keys.next()) {
                    return keys.getInt(1);
                }
            }
            return -1;
        }
    }
    int executeUpdate(String sql) throws SQLException {

        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            return (statement.executeUpdate(sql));
        }
    }

}
