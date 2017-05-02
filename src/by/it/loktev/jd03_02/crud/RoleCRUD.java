package by.it.loktev.jd03_02.crud;

import by.it.loktev.jd03_02.beans.Role;

import java.sql.*;

public class RoleCRUD {

    public Role read(Role role) throws SQLException {
        Role result=null;
        try (
                Connection connection=ConnectorCreator.getConnection();
                Statement statement=connection.createStatement();

        ){
            String SQL="select * from roles where id="+role.getId()+";";
            ResultSet rs=statement.executeQuery(SQL);
            rs.next();
            result=new Role(
                    rs.getInt("id"),
                    rs.getString("name")
            );
            return result;
        }
    }

    public int create(Role role) throws SQLException {
        int id=role.getId();
        try (
                Connection connection=ConnectorCreator.getConnection();
                Statement statement=connection.createStatement();
        ) {
            if (id==0) {
                String SQL = "insert into roles(name) values('" + role.getName() + "');";
                statement.executeUpdate(SQL, Statement.RETURN_GENERATED_KEYS);
                ResultSet keys = statement.getGeneratedKeys();
                keys.next();
                id = keys.getInt(1);
                role.setId(id);
            }
            else{
                String SQL = "insert into roles(id,name) values("+id+",'" + role.getName() + "');";
                statement.executeUpdate(SQL);
            }

        }
        return id;

    }

    public void update(Role role) throws SQLException {
        try (
                Connection connection=ConnectorCreator.getConnection();
                Statement statement=connection.createStatement();
        ) {
            String SQL="update roles set name='"+role.getName()+"' where id="+role.getId()+";";
            statement.executeUpdate(SQL);
        }

    }
}


