package by.it.sorokoee.jd03_02.crud;

import by.it.sorokoee.jd03_02.beans.Role;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RoleCrud {
    public boolean create(Role role) throws SQLException {
        try (Connection connection = ConnectorCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "INSERT INTO `roles`(`role`) " +
                            "VALUES ('%s')", role.getRole()
            );
            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet keys = statement.getGeneratedKeys();
                if (keys.next()) {
                    int id = keys.getInt(1);
                    role.setId(id);
                    return true;
                }
            }
            return false;
        }
    }

    public Role read(Role role){
        return null;
    }
    public boolean update(Role role){
        return false;
    }
    public boolean delete(Role role){
        return false;
    }
}
