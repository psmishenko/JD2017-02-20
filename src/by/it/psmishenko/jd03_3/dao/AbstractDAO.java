package by.it.psmishenko.jd03_3.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by user on 03.05.2017.
 */
public abstract class AbstractDAO {
int executeCreate(String sql) throws SQLException {
    try(Connection connection = ConnectorCreator.getConnection();
        Statement statement = connection.createStatement()){

        if(1==statement.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS)){
            ResultSet keys = statement.getGeneratedKeys();
            if(keys.next()){
                return keys.getInt(1);
            }
        }
    }
    return -1;
}
   boolean executeUpdate(String sql) throws SQLException {
       try(Connection connection = ConnectorCreator.getConnection();
           Statement statement = connection.createStatement()){
           String sql = String.format(" INSERT INTO `users`(`Login`, `Password`, `Email`, `FK_Roles`) VALUES ('%s','%s','%s','%d')"
                   ,user.getLogin(),user.getPassword(),user.getEmail(),user.getFk_roles());
           if(1==statement.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS)){
               ResultSet keys = statement.getGeneratedKeys();
               if(keys.next()){
                   int id = keys.getInt(1);
                   user.setId(id);
                   return true;
               }
           }
       }
       return false;
   }
}
