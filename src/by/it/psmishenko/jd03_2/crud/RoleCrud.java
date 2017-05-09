package by.it.psmishenko.jd03_2.crud;


import by.it.psmishenko.jd03_2.beans.Role;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by user on 29.04.2017.
 */
public class RoleCrud {
  public   boolean create(Role role){
        try( Connection connection = ConnectorCreator.getConnection();
            Statement statement = connection.createStatement()){
            String sql = String.format(" INSERT INTO `roles`(`Role`) VALUES ('%s')",role.getRole());
             if(1==statement.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS)){
                 ResultSet keys = statement.getGeneratedKeys();
                 if(keys.next()){
                     int id = keys.getInt(1);
                     role.setId(id);
                     return true;
                 }
             }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public  boolean update(Role role) throws SQLException {
        try( Connection connection = ConnectorCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("UPDATE `roles` SET `Role`= '%s' WHERE ID=%d", role.getRole(), role.getId());
            return (1 == statement.executeUpdate(sql));
        }
    }
    public  Role read(Role role) throws SQLException {
      Role resultRole = null;
        try (Connection connection = ConnectorCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "SELECT `ID`, `Role` FROM `roles` WHERE ID=%d",
                    role.getId()
            );
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) {
                resultRole = new Role(rs.getInt("ID"),rs.getString("Role"));
            }
        }
        return resultRole;
    }
    public  boolean delete(Role role) throws SQLException {
        try (Connection connection = ConnectorCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("DELETE FROM `roles` WHERE ID=%d", role.getId()
            );
            return (1 == statement.executeUpdate(sql));
        }
    }
    public int getRoleID(String role) throws SQLException {
        int id = 0;
        try (Connection connection = ConnectorCreator.getConnection();
             Statement statement = connection.createStatement()) {
           String sql = String.format("SELECT `ID`, `Role` FROM `roles` WHERE `Role` = '%s'",role);
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                id = rs.getInt("ID");
            }
        }
        return id;
    }
}
