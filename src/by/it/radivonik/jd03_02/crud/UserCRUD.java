package by.it.radivonik.jd03_02.crud;

import by.it.radivonik.jd03_02.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Radivonik on 29.04.2017.
 */
public class UserCRUD {
    public boolean create(User user) throws SQLException {
        try (Connection connection = ConnectionCreater.getConnection();
             Statement statement = connection.createStatement();) {
            String sql = String.format(
                    "INSERT INTO users (login, password, email, fk_roles) VALUES ('%s', '%s', '%s', %d)",
                    user.getLogin(), user.getPassword(), user.getEmail(), user.getId_role());
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
        try (Connection connection = ConnectionCreater.getConnection();
             Statement statement = connection.createStatement();) {
            String sql = String.format("SELECT * FROM users WHERE id = %d", user.getId());
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                return new User(
                    resultSet.getInt("id"),
                    resultSet.getString("login"),
                    resultSet.getString("password"),
                    resultSet.getString("email"),
                    resultSet.getInt("fk_roles"));
            }
        }
        return null;
    }

    public boolean update(User user) {
        return false;
    }

    public boolean delete(User user) {
        return false;
    }
}
