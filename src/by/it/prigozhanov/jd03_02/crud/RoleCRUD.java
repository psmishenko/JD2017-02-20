package by.it.prigozhanov.jd03_02.crud;

import by.it.prigozhanov.jd03_02.beans.Role;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by v-omf on 4/29/2017!
 */
public class RoleCRUD {

    public boolean create(Role role) throws SQLException {
        try (Connection connection = ConnectorCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "INSERT INTO `roles`(`Role`)" +
                            " VALUES ('%s')", role.getRole()
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

    public Role read(Role role) throws SQLException {
        Role result = null;
        try (Connection connection = ConnectorCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("SELECT `ID`, `Role` FROM `roles` WHERE ID=%d", role.getId());
            ResultSet keys = statement.executeQuery(sql);
                if (keys.next()) {
                    result=new Role(keys.getInt("ID"),keys.getString("Role"));
                }
        }
        return result;
    }

    public boolean update(Role role) throws SQLException {
        try (Connection connection = ConnectorCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "UPDATE `roles` SET `Role`='%s' WHERE ID=%d",
                    role.getRole(), role.getId()
                    );
            return (1 == statement.executeUpdate(sql));
        }
    }

    public boolean delete(Role role) throws SQLException {
        try (Connection connection = ConnectorCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("DELETE FROM `roles` WHERE ID = %d", role.getId());
            return (1 == statement.executeUpdate(sql));
        }
    }




}



