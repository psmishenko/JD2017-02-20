package by.it.kolenda.jd03_02.crud;

import by.it.kolenda.jd03_02.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserCreateRead {

          public boolean create(User user) throws SQLException {
            try (Connection connection = ConnectionCreator.getConnection();
                 Statement statement = connection.createStatement()) {
                String sql = String.format(
                        "INSERT INTO `users`(`Login`, `Password`, `Email`, `FK_roles`) " +
                                "VALUES ('%s','%s','%s',%d);",
                        user.getLogin(), user.getPassword(), user.getEmail(), user.getFk_roles()
                );
                System.out.println(sql);
                if(1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
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
            try (Connection connection = ConnectionCreator.getConnection();
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
    }