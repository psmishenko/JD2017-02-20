package by.it.zeynalov.project.java.dao;




import by.it.zeynalov.project.java.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsersDAO extends AbstractDAO implements InterfaceDAO<User> {
    public boolean create(User user) throws SQLException {
        String sql = String.format(
                "INSERT INTO `users`(`Login`, `Password`, `Email`, `FC_rolles`) " +
                        "VALUES ('%s','%s','%s',%d);",
                user.getLogin(), user.getPassword(), user.getEmail(), user.getFc_rolles()
        );
        int id = executeCreate(sql);
        if (id > 0) {
            user.setId(id);
            return true;
        }
        return false;
    }

    public User read(int id) throws SQLException {
        String whereString = String.format(" Where ID = %d", id);
        List<User> listUser = getAll(whereString);
        if (listUser.size() == 1) {
            return listUser.get(0);
        }
        return null;
    }

    public boolean update(User user) throws SQLException {
        String sql = String.format(
                "UPDATE `users` SET " +
                        "`Login`='%s'," +
                        "`Password`='%s'," +
                        "`Email`='%s'," +
                        "`FC_rolles`=%d " +
                        "WHERE ID=%d",
                user.getLogin(),
                user.getPassword(),
                user.getEmail(),
                user.getFc_rolles(),
                user.getId()
        );
        return executeUpdate(sql);
    }

    public boolean delete(User user) throws SQLException {
        String sql = String.format(
                "DELETE FORM `users` WHERE ID=%d",
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
                    "SELECT `ID`, `Login`, `Password`, `Email`, `FC_rolles` FROM `users` %s;",
                    whereString
            );
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                User user = new User(
                        rs.getInt("ID"),
                        rs.getString("Login"),
                        rs.getString("Password"),
                        rs.getString("Email"),
                        rs.getInt("FC_rolles")
                );
                result.add(user);
            }
        }
        return result;
    }
}
