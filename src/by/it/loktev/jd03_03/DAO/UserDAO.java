package by.it.loktev.jd03_03.DAO;

import by.it.loktev.jd03_03.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends AbstractDAO implements InterfaceDAO<User> {

    @Override
    public List<User> getAll(String whereString) throws SQLException {
        List<User> list=new ArrayList<User>();
        try (
                Connection connection= ConnectorCreator.getConnection();
                Statement statement=connection.createStatement();

        ){
            String SQL="select * from users;";
            ResultSet rs=statement.executeQuery(SQL);
            while ( rs.next() ) {
                User user=new User(
                        rs.getInt("id"),
                        rs.getString("login"),
                        rs.getString("Password"),
                        rs.getString("Email"),
                        rs.getInt("roleid")
                );
                list.add(user);
            }
            return list;
        }

    }

    @Override
    public User read(int id) throws SQLException {
        List<User> list=getAll(" where id="+id+" ");
        if ( list.size()==1 ){
            return list.get(0);
        }
        return null;
    }

    @Override
    public boolean create(User user) throws SQLException {
        int id=user.getId();
        if (id==0) {
            String SQL = "insert into users(login,password,email,roleid) values('" + user.getLogin() + "','" + user.getPassword() + "','" + user.getEmail() + "'," + user.getRoleId() + ");";
            id=executeCreate(SQL);
            if ( id>=0 ) {
                user.setId(id);
                return true;
            }
            return false;
        }
        else {
            String SQL = "insert into users(id,login,password,email,roleid) values("+id+",'" + user.getLogin() + "','" + user.getPassword() + "','" + user.getEmail() + "'," + user.getRoleId() + ");";
            return (1==executeUpdate(SQL));
        }
    }

    @Override
    public boolean update(User user) throws SQLException {
        String SQL="update users set login='"+user.getLogin()+"',password='"+user.getPassword()+"',email='"+user.getEmail()+"',roleid='"+user.getRoleId()+"' where id="+user.getId()+";";
        return (1==executeUpdate(SQL));
    }

    @Override
    public boolean delete(User user) throws SQLException {
        String SQL="delete from users where id="+user.getId()+";";
        return (1==executeUpdate(SQL));
    }

}
