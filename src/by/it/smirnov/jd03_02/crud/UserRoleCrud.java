package by.it.smirnov.jd03_02.crud;

import by.it.smirnov.jd03_02.Connection.ConnectorCreator;
import by.it.smirnov.jd03_02.bean.UserRole;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

/**
 * Created by aleksey.smirnov on 01.05.2017.
 */
public class UserRoleCrud extends AbstractCrud<UserRole>{
    private static final String selectSQL = "SELECT `id`, `iduser`, `idrole` FROM `usersroles` WHERE ID=?";
    private static final String insertSQL = "INSERT INTO `usersroles`(`id`, `iduser`, `idrole`) VALUES (?,?,?);";
    private static final String updateSQL = "UPDATE `usersroles` SET `iduser`=?, `idrole`=? WHERE ID=?";
    private static final String deleteSQL = "DELETE FROM `usersroles` WHERE ID=?";

    @Override
    UserRole CreateElement(ResultSet rs) throws SQLException {
        return new UserRole(
                rs.getInt("ID"),
                rs.getInt("iduser"),
                rs.getInt("idrole")
        );
    }

    @Override
    UserRole CreateElement(int id) {
        UserRole userRole = new UserRole();
        userRole.setId(id);
        return userRole;
    }

    @Override
    PreparedStatement getStatementInsertSQL(UserRole userRole) throws SQLException {
        PreparedStatement ps = ConnectorCreator.getConnection().prepareStatement(insertSQL, RETURN_GENERATED_KEYS);
        ps.setInt(1,userRole.getId());
        ps.setInt(2,userRole.getIduser());
        ps.setInt(3,userRole.getIdrole());
        return ps;
    }

    @Override
    PreparedStatement getStatementUpdateSQL(UserRole userRole) throws SQLException {
        PreparedStatement ps = ConnectorCreator.getConnection().prepareStatement(updateSQL);
        ps.setInt(1,userRole.getIduser());
        ps.setInt(2,userRole.getIdrole());
        ps.setInt(3,userRole.getId());
        return ps;
    }

    @Override
    PreparedStatement getStatementDeleteSQL(UserRole userRole) throws SQLException {
        PreparedStatement ps = ConnectorCreator.getConnection().prepareStatement(deleteSQL);
        ps.setInt(1,userRole.getId());
        return ps;
    }

    @Override
    PreparedStatement getStatementSelectSQL(UserRole userRole) throws SQLException{
        PreparedStatement ps = ConnectorCreator.getConnection().prepareStatement(selectSQL);
        ps.setInt(1,userRole.getId());
        return ps;
    }

}