package by.it.sorokoee.project.java.daouniv;



import by.it.sorokoee.project.java.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends AbDAO implements IDAO<User> {
    public boolean create(User user) throws SQLException {
        String sql = String.format(
                "INSERT INTO `users`(`login`, `password`, `email`, `fk_roles`) " +
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
                " WHERE id=%d", id
        );
        List<User> listUsers=getAll(whereString);
        if (listUsers.size()==1){
            return listUsers.get(0);
        }
        return null;
    }

    public boolean update(User user) throws SQLException {
        String sql = String.format(
                "UPDATE `users` SET " +
                        "`login`='%s'," +
                        "`password`='%s'," +
                        "`email`='%s'," +
                        "`fk_roles`=%d " +
                        "WHERE id=%d",
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
                "DELETE FROM `users` WHERE id=%d",
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
                    "SELECT `id`, `login`, `password`, `email`, `fk_roles` FROM `users` %s;",
                    whereString
            );
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                User user = new User(
                        rs.getInt("id"),
                        rs.getString("login"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getInt("fk_roles")
                );
                result.add(user);
            }
        }
        return result;
    }
}
