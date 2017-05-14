package by.it.loktev.project.java.dao;

import by.it.loktev.project.java.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDAO extends AbstractDAO implements InterfaceDAO<User> {

    static private UserDAO instance;
    static private Map<Integer, User> map;

    private UserDAO(){
    }

    static UserDAO getInstance(){
        if ( instance==null ) {
            synchronized (UserDAO.class) {
                if (instance == null) {
                    instance = new UserDAO();
                }
            }
        }
        return instance;
    }

    @Override
    public List<User> getAll(String whereString) throws SQLException {
        List<User> list=new ArrayList<User>();
        try (
                Connection connection= ConnectorCreator.getConnection();
                Statement statement=connection.createStatement();

        ){
            String SQL="select * from users "+whereString+";";
            ResultSet rs=statement.executeQuery(SQL);
            while ( rs.next() ) {
                User user=new User(
                        rs.getInt("id"),
                        rs.getString("login"),
                        rs.getString("passhash"),
                        rs.getString("email"),
                        rs.getInt("roleid")
                );
                list.add(user);
            }
            return list;
        }

    }

    public Map<Integer, User> getMap()  {
        Map<Integer,User> map=new HashMap<>();
        try {
            List<User> list= getAll("");
            for ( User user : list ){
                map.put(user.getId(),user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }

    public User getById(int Id){
        if ( map==null ) {
            synchronized (StatusDAO.class) {
                if (map == null) {
                    map = getMap();
                }
            }
        }
        return map.get(Id);
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
            String SQL = "insert into users(login,passhash,email,roleid) values('" + user.getLogin() + "','" + user.getPassHash() + "','" + user.getEmail() + "'," + user.getRoleId() + ");";
            id=executeCreate(SQL);
            if ( id>=0 ) {
                user.setId(id);
                return true;
            }
            return false;
        }
        else {
            String SQL = "insert into users(id,login,passhash,email,roleid) values("+id+",'" + user.getLogin() + "','" + user.getPassHash() + "','" + user.getEmail() + "'," + user.getRoleId() + ");";
            return (1==executeUpdate(SQL));
        }
    }

    @Override
    public boolean update(User user) throws SQLException {
        String SQL="update users set login='"+user.getLogin()+"',passhash='"+user.getPassHash()+"',email='"+user.getEmail()+"',roleid='"+user.getRoleId()+"' where id="+user.getId()+";";
        return (1==executeUpdate(SQL));
    }

    @Override
    public boolean delete(User user) throws SQLException {
        String SQL="delete from users where id="+user.getId()+";";
        return (1==executeUpdate(SQL));
    }

}
