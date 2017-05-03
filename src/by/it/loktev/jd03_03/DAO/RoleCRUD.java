package by.it.loktev.jd03_03.DAO;

import by.it.loktev.jd03_03.beans.Role;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RoleCRUD extends AbstractDAO implements InterfaceDAO<Role> {

    @Override
    public List<Role> getAll(String whereString) throws SQLException {
        List<Role> result=new ArrayList<Role>();
        try (
                Connection connection= ConnectorCreator.getConnection();
                Statement statement=connection.createStatement();

        ){
            String SQL="select * from roles;";
            ResultSet rs=statement.executeQuery(SQL);
            while ( rs.next() ) {
                Role role=new Role(
                        rs.getInt("id"),
                        rs.getString("name")
                );
                result.add(role);
            }
            return result;
        }

    }

    @Override
    public Role read(int id) throws SQLException {
        List<Role> roles=getAll(" where id="+id+" ");
        if ( roles.size()==1 ){
            return roles.get(0);
        }
        return null;
    }

    @Override
    public boolean create(Role role) throws SQLException {
        int id=role.getId();
        if (id==0) {
            String SQL = "insert into roles(name) values('" + role.getName() + "');";
            id=executeCreate(SQL);
            role.setId(id);
        }
        else{
            String SQL = "insert into roles(id,name) values("+id+",'" + role.getName() + "');";
            executeUpdate(SQL);
        }
        return true;
    }

    @Override
    public boolean update(Role role) throws SQLException {
        String SQL="update roles set name='"+role.getName()+"' where id="+role.getId()+";";
        executeUpdate(SQL);
        return true;
    }

    @Override
    public boolean delete(Role entity) throws SQLException {
        String SQL="delete from roles where id="+entity.getId()+";";
        executeUpdate(SQL);
        return true;
    }
}


