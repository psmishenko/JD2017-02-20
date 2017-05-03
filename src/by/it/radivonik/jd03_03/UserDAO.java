package by.it.radivonik.jd03_03;

import by.it.radivonik.jd03_03.beans.User;
import by.it.radivonik.jd03_03.crud.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Radivonik on 03.05.2017.
 */
public class UserDAO extends AbstractDAO implements InterfaceDAO<User> {
    @Override
    public boolean create(User user) throws SQLException {
        String sql = "INSERT INTO users (login, password, email, id_role) VALUES ('%s', '%s', '%s', %d)";
        int id = executeCreate(String.format(sql, user.getLogin(), user.getPassword(), user.getEmail(), user.getIdRole()));
        user.setId(id);
        return id > 0;
    }

    @Override
    public boolean update(User user) throws SQLException {
        String sql = "UPDATE users SET login = '%s', password = '%s', email = '%s', id_role = %d WHERE id = %d";
        int res = executeUpdate(String.format(sql, user.getLogin(), user.getPassword(), user.getEmail(), user.getIdRole(), user.getId()));
        return res > 0;
    }

    @Override
    public boolean delete(User user) throws SQLException {
        String sql = "DELETE FROM users WHERE id = %d";
        int res = executeUpdate(String.format(sql, user.getId()));
        return res > 0;
    }

    @Override
    public List<User> getAll(String where) throws SQLException {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users " + where;
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement();) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                User user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getString("email"),
                        resultSet.getInt("id_role"));
                users.add(user);
            }
        }
        return users;
    }

    @Override
    public User read(int id) throws SQLException {
        List<User> users = getAll("WHERE id = " + id);
        if (users.size() > 0)
            return users.get(0);
        return null;
    }
}
