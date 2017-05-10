package by.it.zeynalov.jd03_02.homework.crud;

import by.it.zeynalov.jd03_02.homework.beans.Role;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RoleCRUD {
    public boolean create(Role role) throws SQLException {
        try (Connection connection = ConnectorCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "INSERT INTO `roles`(`Title`) " +
                            "VALUES ('%s')", role.getTitle()
            );
            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet keys = statement.getGeneratedKeys();
                if (keys.next()) {
                    int id = keys.getInt(1);
                    role.setId(id);
                    return true;
                }
            }
            return false;
        }
    }

    public List<Role> readAll() throws SQLException {
        List<Role> result = new ArrayList<>();
        try (Connection connection = ConnectorCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = "SELECT ID, title FROM roles";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                result.add(new Role(
                        rs.getInt("ID"),
                        rs.getString("Title")
                ));
            }
        }
        return result;
    }

    public Role readById(int id) throws SQLException {
        Role result = null;
        try (Connection connection = ConnectorCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "SELECT `ID`,`title` FROM `roles` WHERE ID=%d",
                    id
            );
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) {
                result = new Role(
                        rs.getInt("id"),
                        rs.getString("title")
                );
            }
        }
        return result;
    }

    public Role read(Role role) {
        return null;
    }

    public boolean update(Role role) {
        return false;
    }

    public boolean delete(Role role) {
        return false;
    }
}
