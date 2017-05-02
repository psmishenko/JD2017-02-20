package by.it.loktev.jd03_02.crud;

import by.it.loktev.jd03_02.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserCRUD {

    public User read(User user) throws SQLException {
        User result=null;
        try (
                Connection connection=ConnectorCreator.getConnection();
                Statement statement=connection.createStatement();

        ){
            String SQL="select * from users where id="+user.getId()+";";
            ResultSet rs=statement.executeQuery(SQL);
            rs.next();
            result=new User(
                    rs.getInt("id"),
                    rs.getString("login"),
                    rs.getString("Password"),
                    rs.getString("Email"),
                    rs.getInt("roleid")
            );
            return result;
        }
    }

    public int create(User user) throws SQLException {
        try (
                Connection connection=ConnectorCreator.getConnection();
                Statement statement=connection.createStatement();
        ) {
            String SQL="insert into users(login,password,email,roleid) values('"+user.getLogin()+"','"+user.getPassword()+"','"+user.getEmail()+"',"+user.getRoleId()+");";
            statement.executeUpdate(SQL,Statement.RETURN_GENERATED_KEYS);
            ResultSet keys=statement.getGeneratedKeys();
            keys.next();
            int id=keys.getInt(1);
            user.setId(id);
            return id;
        }

    }

    public void update(User user) throws SQLException {
        try (
                Connection connection=ConnectorCreator.getConnection();
                Statement statement=connection.createStatement();
        ) {
            String SQL="update users set login='"+user.getLogin()+"',password='"+user.getPassword()+"',email='"+user.getEmail()+"',roleid='"+user.getRoleId()+"' where id="+user.getId()+";";
            statement.executeUpdate(SQL);
        }

    }

    public void delete(User user) throws SQLException {
        try (
                Connection connection=ConnectorCreator.getConnection();
                Statement statement=connection.createStatement();
        ) {
            String SQL="delete from users where id="+user.getId()+";";
            statement.executeUpdate(SQL);
        }

    }
}
