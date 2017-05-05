package by.it.kolenda.jd03_02.crud;

import by.it.kolenda.jd03_02.beans.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UserUpdateDelete {
    public boolean update(User user) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
            "UPDATE `users` SET " + "`Login`='%s'," + "`Password`='%s'," + "`Email`='%s'," + "`FK_roles`=%d " + "WHERE ID=%d",
                    user.getLogin(), user.getPassword(), user.getEmail(), user.getFk_roles(), user.getId()
            );
            System.out.println(sql);
            return (1 == statement.executeUpdate(sql));
        }
    }
    public boolean delete(User user) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "DELETE FROM `users` WHERE ID=%d",
                    user.getId()
            );
            return (1 == statement.executeUpdate(sql));
        }

    }
}


