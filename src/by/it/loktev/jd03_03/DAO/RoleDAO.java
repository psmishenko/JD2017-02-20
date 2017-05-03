package by.it.loktev.jd03_03.DAO;

import by.it.loktev.jd03_03.beans.Role;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RoleDAO extends AbstractDAO implements InterfaceDAO<Role> {

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


