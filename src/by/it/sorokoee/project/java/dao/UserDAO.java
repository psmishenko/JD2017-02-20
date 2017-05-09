package by.it.sorokoee.project.java.dao;


import by.it.sorokoee.project.java.beans.User;
import by.it.sorokoee.project.java.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends AbDAO implements IDAO<User> {
    @Override
    public boolean create(User user) {
        String sql = String.format(
                "insert INTO users(login,password,email,fk_roles)" +
                        " values('%s','%s','%s',%d);",
                user.getLogin(), user.getPassword(), user.getEmail(), user.getFk_roles()
        );
        user.setId(executeUpdate(sql));
        return (user.getId()>0);
    }

    @Override
    public User read(int id) {
        List<User> users = getAll("WHERE id=" + id + " LIMIT 0,1");
        if (users.size() > 0) {
            return users.get(0);
        } else
            return null;
    }

    @Override
    public boolean update(User user) {
        String sql = String.format(
                "UPDATE `users` SET `login` = '%s', `password` = '%s', `email` = '%s', `fk_roles` = '%d' WHERE `users`.`id` = %d",
                user.getLogin(), user.getPassword(), user.getEmail(), user.getFk_roles(), user.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(User user) {
        String sql = String.format(
                "DELETE FROM `users` WHERE `users`.`id` = %d;", user.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public List<User> getAll(String WHERE) {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                User user = new User();
                        user.setId(rs.getInt("id"));
                        user.setLogin(rs.getString("login"));
                        user.setPassword(rs.getString("password"));
                        user.setEmail(rs.getString("email"));
                user.setFk_roles(rs.getInt("fk_roles"));
                users.add(user);
            }
        }
        catch (SQLException e){

        }
        return users;
    }
}
