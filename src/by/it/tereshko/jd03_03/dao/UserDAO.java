package by.it.tereshko.jd03_03.dao;

import by.it.tereshko.jd03_03.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends AbstractDAO implements InterfaceDAO<User> {

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

    public User read(int id) throws SQLException {
        String whereString = String.format(
                " WHERE ID=%d", id
        );
        List<User> listUsers = getAll(whereString);
        if (listUsers.size() == 1) {
            return listUsers.get(0);
        }
        return null;
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
    }

    public boolean delete(User user) throws SQLException {
        String sql = String.format(
                "DELETE FROM `users` WHERE ID=%d",
                user.getId()
        );
        return executeUpdate(sql);
    }

    @Override
    public List<User> getAll(String whereString) throws SQLException {
        List<User> result = new ArrayList<>();
        try (Connection connection = ConnectorCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "SELECT `ID`, `Login`, `Password`, `Email`, `FK_roles` FROM `users` %s;",
                    whereString
            );
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                User user = new User(
                        rs.getInt("ID"),
                        rs.getString("Login"),
                        rs.getString("Password"),
                        rs.getString("Email"),
                        rs.getInt("FK_roles")
                );
                result.add(user);
            }
        }
        return result;
    }

}