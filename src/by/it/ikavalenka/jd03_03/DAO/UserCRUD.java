package by.it.ikavalenka.jd03_03.DAO;


import by.it.ikavalenka.jd03_03.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserCRUD extends AbstractDAO implements IDAO{
    public boolean create(User user) throws SQLException {

        String sql = String.format(
                "INSERT INTO `users`(`Login`, `Password`, `Email`, `FK_roles`) " +
                        "VALUES ('%s','%s','%s',%d);",
                user.getLogin(), user.getPassword(), user.getEmail(), user.getFk_roles()
        );
        int id = executeCreate(sql);
        if (id > 0) {
            user.setId(id);
            return true;
        }
        return false;
    }

    public User read(User user) throws SQLException {
        User result = null;
        try (Connection connection = ConnectorCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "SELECT `ID`, `Login`, `Password`, `Email`, `FK_roles` FROM `users` WHERE ID=%d",
                    user.getId()
            );
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) {
                result = new User(
                        rs.getInt("ID"),
                        rs.getString("Login"),
                        rs.getString("Password"),
                        rs.getString("Email"),
                        rs.getInt("FK_roles")
                );
            }
        }
        return result;
    }

    public boolean update(User user) throws SQLException {

            String sql = String.format(
                    "UPDATE `users` SET " +
                            "`Login`='%s'," +
                            "`Password`='%s'," +
                            "`Email`='%s'," +
                            "`FK_roles`=%d " +
                            "WHERE ID=%d",
                    user.getLogin(),
                    user.getPassword(),
                    user.getEmail(),
                    user.getFk_roles(),
                    user.getId()
            );
            return executeUpdate(sql);
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
