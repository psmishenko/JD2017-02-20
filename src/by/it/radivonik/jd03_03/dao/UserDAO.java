package by.it.radivonik.jd03_03.dao;

import by.it.radivonik.jd03_03.beans.User;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Created by Radivonik on 03.05.2017.
 */
public class UserDAO extends AbstractDAO<User> {
    @Override
    protected String sqlSelect() {
        return "SELECT * FROM user";
    }

    @Override
    protected String sqlWhereId(int id) {
        return "WHERE user.id = " + id;
    }

    @Override
    protected String sqlInsert(User user) {
        String sql = "INSERT INTO user (login, password, email, id_role) VALUES ('%s', '%s', '%s', %d)";
        return String.format(sql, user.getLogin(), user.getPassword(), user.getEmail(), user.getIdRole());
    }

    @Override
    protected String sqlUpdate(User user) {
        String sql = "UPDATE user SET login = '%s', password = '%s', email = '%s', id_role = %d WHERE id = %d";
        return String.format(sql, user.getLogin(), user.getPassword(), user.getEmail(), user.getIdRole(), user.getId());
    }

    @Override
    protected String sqlDelete(User user) {
        String sql = "DELETE FROM user WHERE id = %d";
        return String.format(sql, user.getId());
    }

    @Override
    protected void setId(User user, int id) {
        user.setId(id);
    }

    @Override
    protected User newBean(ResultSet resultSet) throws SQLException {
        User user = new User(
            resultSet.getInt("id"),
            resultSet.getString("login"),
            resultSet.getString("password"),
            resultSet.getString("email"),
            resultSet.getInt("id_role"));
        return user;
    }
}
