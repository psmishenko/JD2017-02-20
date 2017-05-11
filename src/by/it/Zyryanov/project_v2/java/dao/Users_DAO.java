package by.it.Zyryanov.project_v2.java.dao;




import by.it.Zyryanov.project_v2.java.beans.Users;
import by.it.Zyryanov.project_v2.java.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Users_DAO extends AbstractDAO implements interfaceDAO<Users> {
    @Override
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

    @Override
    public Users read(int id) {

        List<Users> users = getAll("WHERE ID = " + id + "LIMIT 0,1");
        if (users.size() > 0) {
            return users.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(Users user) {
        String sql = String.format(
                "INSERT INTO Users(Login, Password, Email, fk_Roles)" +
                        " VALUES ('%s', '%s', '%s', '%d');",
                user.getLogin(),
                user.getPassword(),
                user.getEmail(),
                user.getFk_Roles()
        );
        user.setId(executeUpdate(sql));
        return (user.getId() > 0);
    }

    @Override
    public boolean update(Users user) {
        String sql = String.format(
                "UPDATE Users SET " +
                        "Login = %s, " +
                        "Password = %s, " +
                        "Email = %s , " +
                        "fk_Roles = %d WHERE ID = %d",
                user.getLogin(),
                user.getPassword(),
                user.getEmail(),
                user.getFk_Roles(),
                user.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(Users user) {
        String sql = String.format(
                "DELETE FROM Users WHERE ID = %d",
                user.getId()
        );
        return (0 < executeUpdate(sql));
    }
}
