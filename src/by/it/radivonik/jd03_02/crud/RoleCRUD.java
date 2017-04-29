package by.it.radivonik.jd03_02.crud;

import by.it.radivonik.jd03_02.beans.Role;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Radivonik on 29.04.2017.
 */
public class RoleCRUD {
    public boolean create(Role role) throws SQLException {
        try (
            Connection connection = ConnectionCreater.getConnection();
            Statement statement = connection.createStatement(); ) {
            String sql = String.format("INSERT INTO roles (role) VALUES ('%s')",role.getRole());
            if (statement.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS) == 1) {
                ResultSet keys = statement.getGeneratedKeys();
                if (keys.next()) {
                    role.setId(keys.getInt(1));
                    return true;
                }
            }
        }
        return false;
    }

    public Role read(Role role) {
        return null;
    }

    public boolean update(Role role) {
        return false;
    }

    public boolean delete(Role role) {
        return false;
    }
}
