package by.it.psmishenko.jd03_2.crud;

import by.it.psmishenko.jd03_2.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by user on 29.04.2017.
 */
public class UserCrud {
    public   boolean create(User user) throws SQLException {
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
    public  boolean update(User user){
        return false;
    }
    public  User read(User user) throws SQLException {
        User resultUser = null;
        try(Connection connection = ConnectorCreator.getConnection();
            Statement statement = connection.createStatement()) {
            String sql = String.format(" SELECT `users`(`Login`, `Password`, `Email`, `FK_Roles`) VALUES ('%s','%s','%s','%d')"    // SELECT!!!!!!!!!!!!!!!!!
                    , user.getLogin(), user.getPassword(), user.getEmail(), user.getFk_roles());
            ResultSet rs = statement.executeQuery(sql);
            if(rs.next()){
                resultUser = new User(rs.getInt("ID"),rs.getString("Login"),rs.getString("Password")) // new user

            }
        }
        return resultUser;
    }
    public  boolean delete(User user){
        return false;
    }
}
