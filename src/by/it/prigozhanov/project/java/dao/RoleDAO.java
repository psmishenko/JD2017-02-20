package by.it.prigozhanov.project.java.dao;

import by.it.prigozhanov.project.java.beans.Role;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by v-omf on 4/29/2017!
 */
public class RoleDAO extends AbstractDAO implements InterfaceDAO<Role> {

    public boolean create(Role role) throws SQLException {
        String sql = String.format(
                "INSERT INTO `roles`(`Role`) VALUES ('%s')", role.getRole()
        );
        int id = executeCreate(sql);
        if (id > 0) {
            role.setId(id);
            return true;
        }
        return false;
    }

    public Role read(int id) throws SQLException {
        String sql = String.format("WHERE ID=%d", id);
        List<Role> listRoles = getAll(sql);
        if (listRoles.size() == 1) {
            return listRoles.get(0);
        }
        return null;
    }

    public boolean update(Role role) throws SQLException {
        String sql = String.format(
                "UPDATE `roles` SET `Role`='%s' WHERE ID=%d",
                role.getRole(), role.getId()
        );
        return (executeUpdate(sql));
    }

    public boolean delete(Role role) throws SQLException {
        String sql = String.format("DELETE FROM `roles` WHERE ID = %d", role.getId());
        return executeUpdate(sql);
    }

    @Override
    public List getAll(String whereString) throws SQLException {
        List<Role> listRoles = new ArrayList<>();
        try (Connection connection = ConnectorCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("SELECT `ID`, `Role` FROM `roles` %s", whereString);
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                listRoles.add(
                        new Role(
                                rs.getInt("ID"),
                                rs.getString("Role")
                        )
                );
            }
        }
        return listRoles;
    }
}



