package by.it.smirnov.jd03_02.crud;

import by.it.smirnov.jd03_02.Connection.ConnectorCreator;
import by.it.smirnov.jd03_02.bean.Role;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

/**
 * Created by aleksey.smirnov on 01.05.2017.
 */
public class RoleCrud extends AbstractCrud<Role>{
    private static final String selectSQL = "SELECT `id`, `name` FROM `roles` WHERE ID=?";
    private static final String insertSQL = "INSERT INTO `roles`(`id`, `name`) VALUES (?,?);";
    private static final String updateSQL = "UPDATE `roles` SET `name`=? WHERE ID=?";
    private static final String deleteSQL = "DELETE FROM `roles` WHERE ID=?";

    @Override
    Role CreateElement(ResultSet rs) throws SQLException {
        return new Role(
                rs.getInt("ID"),
                rs.getString("name")
        );
    }

    @Override
    Role CreateElement(int id) {
        Role role = new Role();
        role.setId(id);
        return role;
    }

    @Override
    PreparedStatement getStatementInsertSQL(Role role) throws SQLException {
        PreparedStatement ps = ConnectorCreator.getConnection().prepareStatement(insertSQL, RETURN_GENERATED_KEYS);
        ps.setInt(1,role.getId());
        ps.setString(2,role.getName());
        return ps;
    }

    @Override
    PreparedStatement getStatementUpdateSQL(Role role) throws SQLException {
        PreparedStatement ps = ConnectorCreator.getConnection().prepareStatement(updateSQL);
        ps.setString(1,role.getName());
        ps.setInt(2,role.getId());
        return ps;
    }

    @Override
    PreparedStatement getStatementDeleteSQL(Role role) throws SQLException {
        PreparedStatement ps = ConnectorCreator.getConnection().prepareStatement(deleteSQL);
        ps.setInt(1,role.getId());
        return ps;
    }

    @Override
    PreparedStatement getStatementSelectSQL(Role role) throws SQLException{
        PreparedStatement ps = ConnectorCreator.getConnection().prepareStatement(selectSQL);
        ps.setInt(1,role.getId());
        return ps;
    }

}

