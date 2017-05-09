package by.it.radivonik.jd03_02.crud;

import by.it.radivonik.jd03_02.beans.User;
import by.it.radivonik.jd03_02.connection.ConnectionCreator;
import java.sql.*;

/**
 * Created by Radivonik on 29.04.2017.
 */
public class UserCRUD {
    public boolean create(User user) throws SQLException {
        try (
            Connection connection = ConnectionCreator.getConnection();
            Statement statement = connection.createStatement()) {
            String sql = String.format(
                "INSERT INTO user (login, password, email, id_role) VALUES ('%s', '%s', '%s', %d)",
                user.getLogin(), user.getPassword(), user.getEmail(), user.getIdRole());
            if (statement.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS) == 1) {
                ResultSet keys = statement.getGeneratedKeys();
                if (keys.next()) {
                    user.setId(keys.getInt(1));
                    return true;
                }
            }
        }
        return false;
    }

    public User read(User user) throws SQLException {
        try (
            Connection connection = ConnectionCreator.getConnection();
            Statement statement = connection.createStatement()) {
            String sql = String.format("SELECT * FROM user WHERE id = %d", user.getId());
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                return new User(
                    resultSet.getInt("id"),
                    resultSet.getString("login"),
                    resultSet.getString("password"),
                    resultSet.getString("email"),
                    resultSet.getInt("id_role"));
            }
        }
        return null;
    }

    public boolean update(User user) throws SQLException {
        String sql = String.format(
            "UPDATE user SET login = '%s', password = '%s', email = '%s', id_role = %d WHERE id = %d",
            user.getLogin(), user.getPassword(), user.getEmail(), user.getIdRole(), user.getId());
        try (
            Connection connection = ConnectionCreator.getConnection();
            Statement statement = connection.createStatement()) {
            return statement.executeUpdate(sql) == 1;
        }
    }

    public boolean delete(User user) throws SQLException {
        String sql = String.format("DELETE FROM user WHERE id = %d", user.getId());
        try (
            Connection connection = ConnectionCreator.getConnection();
            Statement statement = connection.createStatement()) {
            return statement.executeUpdate(sql) == 1;
        }
    }
}
