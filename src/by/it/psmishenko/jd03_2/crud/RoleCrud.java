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
    public  boolean update(Role role){
        return false;
    }
    public  boolean read(Role role){
        return false;
    }
    public  boolean delete(Role role){
        return false;
    }
}
