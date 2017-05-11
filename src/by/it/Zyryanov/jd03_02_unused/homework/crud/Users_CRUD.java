package by.it.Zyryanov.jd03_02_unused.homework.crud;




import by.it.Zyryanov.jd03_02_unused.homework.beans.Users;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Users_CRUD{

    public List<Users> getAll(String WHERE) {

        List<Users> users = new ArrayList<>();

        String sql = "SELECT * FROM users " + WHERE + ";";

        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                Users user = new Users();
                user.setId(rs.getInt("ID"));
                user.setLogin(rs.getString("Login"));
                user.setPassword(rs.getString("Password"));
                user.setEmail(rs.getString("Email"));
                user.setFk_Roles(rs.getInt("fk_Roles"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }


    public boolean create(Users user) throws SQLException {

        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "INSERT INTO Users(Login, Password, Email, fk_Roles)" +
                            " VALUES ('%s', '%s', '%s', '%d');",
                    user.getLogin(),
                    user.getPassword(),
                    user.getEmail(),
                    user.getFk_Roles()
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

    public Users read(Users user) throws SQLException {

        Users result = null;

        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "SELECT ID, Login, Password, Email, fk_Roles FROM Users WHERE ID = '%d'", user.getId()
            );
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) {
                result = new Users(
                        rs.getInt("ID"),
                        rs.getString("Login"),
                        rs.getString("Password"),
                        rs.getString("Email"),
                        rs.getInt("fk_Roles")
                );

            }

        }
        return result;
    }

    public boolean update(Users user) throws SQLException {

        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "UPDATE Users SET " +
                            "Login = '%s', " +
                            "Password = '%s', " +
                            "Email = '%s' , " +
                            "fk_Roles = '%d' " +
                            "WHERE ID = '%d'",
                    user.getLogin(),
                    user.getPassword(),
                    user.getEmail(),
                    user.getFk_Roles(),
                    user.getId()
            );
            return (1 == statement.executeUpdate(sql));
        }
    }


    public boolean delete(Users user) throws SQLException{

        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "DELETE FROM Users WHERE ID = '%d'",
                    user.getId()
            );
            return (1 == statement.executeUpdate(sql));
        }
    }
}
