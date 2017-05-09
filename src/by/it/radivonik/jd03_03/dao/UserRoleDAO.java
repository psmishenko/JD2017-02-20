package by.it.radivonik.jd03_03.dao;

import by.it.radivonik.jd03_03.beans.UserRole;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Radivonik on 05.05.2017.
 */
public class UserRoleDAO extends UserDAO {
    @Override
    protected String sqlSelect() {
        return "SELECT user.*, role.name AS name_role FROM user INNER JOIN role ON user.id_role = role.id";
    }

    @Override
    protected UserRole newBean(ResultSet resultSet) throws SQLException {
        UserRole userRole = new UserRole(
            resultSet.getInt("id"),
            resultSet.getString("login"),
            resultSet.getString("password"),
            resultSet.getString("email"),
            resultSet.getInt("id_role"),
            resultSet.getString("name_role"));
        return userRole;
    }
}
