package by.it.loktev.project.java.dao;

import by.it.loktev.project.java.beans.Role;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoleDAO extends AbstractDAO implements InterfaceDAO<Role> {

    static private RoleDAO instance;
    static private Map<Integer, Role> map;

    private RoleDAO(){
    }

    static RoleDAO getInstance(){
        if ( instance==null ) {
            synchronized (UserDAO.class) {
                if (instance == null) {
                    instance = new RoleDAO();
                }
            }
        }
        return instance;
    }


    @Override
    public List<Role> getAll(String whereString) throws SQLException {
        List<Role> list=new ArrayList<Role>();
        try (
                Connection connection= ConnectorCreator.getConnection();
                Statement statement=connection.createStatement();

        ){
            String SQL="select * from roles "+whereString+";";
            ResultSet rs=statement.executeQuery(SQL);
            while ( rs.next() ) {
                Role role=new Role(
                        rs.getInt("id"),
                        rs.getString("name")
                );
                list.add(role);
            }
            return list;
        }

    }

    public Map<Integer, Role> getMap()  {
        Map<Integer,Role> map=new HashMap<>();
        try {
            List<Role> list= getAll("");
            for ( Role role : list ){
                map.put(role.getId(),role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }

    public Role getById(int Id){
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
    public Role read(int id) throws SQLException {
        List<Role> list=getAll(" where id="+id+" ");
        if ( list.size()==1 ){
            return list.get(0);
        }
        return null;
    }

    @Override
    public boolean create(Role role) throws SQLException {
        int id=role.getId();
        if (id==0) {
            String SQL = "insert into roles(name) values('" + role.getName() + "');";
            id=executeCreate(SQL);
            if ( id>=0 ) {
                role.setId(id);
                return true;
            }
            return false;
        }
        else {
            String SQL = "insert into roles(id,name) values("+id+",'" + role.getName() + "');";
            return (1==executeUpdate(SQL));
        }
    }

    @Override
    public boolean update(Role role) throws SQLException {
        String SQL="update roles set name='"+role.getName()+"' where id="+role.getId()+";";
        return (1==executeUpdate(SQL));
    }

    @Override
    public boolean delete(Role entity) throws SQLException {
        String SQL="delete from roles where id="+entity.getId()+";";
        return (1==executeUpdate(SQL));
    }
}


