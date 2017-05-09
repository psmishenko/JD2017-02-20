package by.it.radivonik.jd03_02.crud;

import by.it.radivonik.jd03_02.beans.Role;
import by.it.radivonik.jd03_02.connection.ConnectionCreator;
import java.sql.*;

/**
 * Created by Radivonik on 29.04.2017.
 */
public class RoleCRUD {
    public boolean create(Role role) throws SQLException {
        try (
            Connection connection = ConnectionCreator.getConnection();
            Statement statement = connection.createStatement();) {
            String sql = String.format("INSERT INTO role (name) VALUES ('%s')", role.getName());
            if (statement.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS) == 1) {
                ResultSet keys = statement.getGeneratedKeys();
                if (keys.next()) {
                    role.setId(keys.getInt(1));
                    return true;
                }
            }
        }
        return false;
    }

    public Role read(Role role) throws SQLException {
        try (
            Connection connection = ConnectionCreator.getConnection();
            Statement statement = connection.createStatement()) {
            String sql = String.format("SELECT * FROM role WHERE id = %d", role.getId());
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                return new Role(
                        resultSet.getInt("id"),
                        resultSet.getString("name"));
            }
        }
        return null;
    }

    public boolean update(Role role) throws SQLException {
        String sql = String.format("UPDATE role SET name = '%s' WHERE id = %d", role.getName(), role.getId());
        try (
            Connection connection = ConnectionCreator.getConnection();
            Statement statement = connection.createStatement()) {
            return statement.executeUpdate(sql) == 1;
        }
    }

    public boolean delete(Role role) throws SQLException {
        String sql = String.format("DELETE FROM role WHERE id = %d", role.getId());
        try (
            Connection connection = ConnectionCreator.getConnection();
            Statement statement = connection.createStatement()) {
            return statement.executeUpdate(sql) == 1;
        }
    }

    public Role readByName(String name) throws SQLException  {
        try (
            Connection connection = ConnectionCreator.getConnection();
            Statement statement = connection.createStatement()) {
            String sql = String.format("SELECT * FROM role WHERE name = '%s'", name);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                return new Role(
                        resultSet.getInt("id"),
                        resultSet.getString("name"));
            }
        }
        return null;
    }
}
