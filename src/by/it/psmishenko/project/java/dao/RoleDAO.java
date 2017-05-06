package by.it.psmishenko.project.java.dao;


import by.it.psmishenko.project.java.beans.Role;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 29.04.2017.
 */
public class RoleDAO extends AbstractDAO implements InterfaceDAO<Role> {
    private static RoleDAO instance;
    private RoleDAO() {
    }
     static RoleDAO getInstance(){
        if(instance==null) {
            synchronized (RoleDAO.class) {
                if (instance == null) {
                    instance = new RoleDAO();
                }
            }
        }
            return instance;
    }

    public   boolean create(Role role) throws SQLException {
            String sql = String.format(" INSERT INTO `roles`(`Role`) VALUES ('%s')",role.getRole());
          int id  =  executeCreate(sql);
            if(id>0){ role.setId(id);
                return true; }
        return false;
    }
    public  boolean update(Role role) throws SQLException {
            String sql = String.format("UPDATE `roles` SET `Role`= '%s' WHERE ID=%d", role.getRole(), role.getId());
            return  executeUpdate(sql);
    }


    public  boolean delete(Role role) throws SQLException {
        try (Connection connection = ConnectorCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("DELETE FROM `roles` WHERE ID=%d", role.getId()
            );
            return (1 == statement.executeUpdate(sql));
        }
    }

    @Override
    public Role read(int id) throws SQLException {
        String whereString = String.format(" WHERE ID=%d", id);
        List<Role> listRoles=getAll(whereString);
        if (listRoles.size()==1){
            return listRoles.get(0);
        }
        return null;
    }

    @Override
    public List<Role> getAll(String whereString) throws SQLException {
      List<Role> res = new ArrayList<>();
        try (Connection connection = ConnectorCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("SELECT `ID`, `Role` FROM `roles` %s;", whereString);
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Role role = new Role(rs.getInt("ID"),rs.getString("Role"));
                res.add(role);
            }
        }
        return res;
    }

}
