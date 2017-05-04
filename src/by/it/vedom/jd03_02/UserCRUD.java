package by.it.vedom.jd03_02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserCRUD {
    public boolean create(User user) throws SQLException {
        try (Connection connection = ConnectorCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "INSERT INTO `users`(`login`, `password`, `email`, `role_role_id`) " +
                            "VALUES ('%s','%s','%s',%d);",
                    user.getLogin(), user.getPassword(), user.getEmail(), user.getRole_role_id()
            );
            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet keys = statement.getGeneratedKeys();
                if (keys.next()) {
                    int id = keys.getInt(1);
                    user.setId(id);
                    return true;
                }
            }
            return false;
        }
    }

    public User read(User user) throws SQLException {
        User result = null;
        try (Connection connection = ConnectorCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "SELECT `id`, `login`, `password`, `email`, `role_role_id` FROM `users` WHERE ID=%d",
                    user.getId()
            );
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) {
                result = new User(
                        rs.getInt("id"),
                        rs.getString("login"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getInt("role_role_id")
                );
            }
        }
        return result;
    }

    public boolean update(User user) throws SQLException {
        try (Connection connection = ConnectorCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "UPDATE `users` SET " +
                            "`Login`='%s'," +
                            "`Password`='%s'," +
                            "`Email`='%s'," +
                            "`role_role_id`=%d " +
                            "WHERE ID=%d",
                    user.getLogin(),
                    user.getPassword(),
                    user.getEmail(),
                    user.getRole_role_id(),
                    user.getId()
            );
            System.out.println(sql);
            return (1 == statement.executeUpdate(sql));
        }
    }

    public boolean delete(User user) throws SQLException {
        try (Connection connection = ConnectorCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "DELETE FROM `users` WHERE ID=%d",
                    user.getId()
            );
            return (1 == statement.executeUpdate(sql));
        }
    }
}
