package by.it.radivonik.project.java.dao;

import by.it.radivonik.project.java.beans.Role;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Radivonik on 03.05.2017.
 */
public class RoleDAO extends AbstractDAO<Role> {
    @Override
    protected String sqlSelect() {
        return "SELECT * FROM role";
    }

    @Override
    protected String sqlInsert(Role role) {
        String sql = "INSERT INTO role (name) VALUES ('%s')";
        return String.format(sql, role.getName());
    }

    @Override
    protected String sqlUpdate(Role role) {
        String sql = "UPDATE role SET name = '%s' WHERE id = %d";
        return String.format(sql, role.getName(), role.getId());
    }

    @Override
    protected String sqlDelete(Role role) {
        String sql = "DELETE FROM role WHERE id = %d";
        return String.format(sql, role.getId());
    }


    @Override
    protected void setId(Role role, int id) {
        role.setId(id);
    }

    @Override
    protected Role newBean() {
        return new Role();
    }

    @Override
    protected Role newBean(ResultSet resultSet) throws SQLException {
        Role role = new Role(
            resultSet.getInt("id"),
            resultSet.getString("name"));
        return role;
    }
}
