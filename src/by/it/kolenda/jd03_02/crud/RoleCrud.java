package by.it.kolenda.jd03_02.crud;

import by.it.kolenda.jd03_02.beans.Role;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RoleCrud {
    public boolean create(Role role) throws SQLException {
        try (Connection connection=ConnectionCreator.getConnection();
        Statement statement = connection.createStatement()){
            String sql = String.format (
                    "INSERT INTO 'roles' ('Role')" + "VALUES (''%s)",role.getRole()
            );
            if (1==statement.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS)){
                ResultSet rs=statement.getGeneratedKeys();
                if (rs.next()){
                    int id=rs.getInt(1);
                   role.setId(id);
                    return true;
                }
            }
        return false;
        }
    }

}
