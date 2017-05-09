package by.it.smirnov.project.java.DAO;

import by.it.smirnov.project.java.Connection.ConnectorCreator;
import by.it.smirnov.project.java.bean.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

/**
 * Created by aleksey.smirnov on 01.05.2017.
 */
public class UserDAO extends AbstractDAO<User> {
    private static final String selectSQL = "SELECT `id`, `name`, `login`, `password` FROM `users`";
    private static final String insertSQL = "INSERT INTO `users`(`id`, `name`, `login`, `password`) VALUES (?,?,?,?);";
    private static final String updateSQL = "UPDATE `users` SET `name`=?, `login`=?, `password`=? WHERE ID=?";
    private static final String deleteSQL = "DELETE FROM `users` WHERE ID=?";
    private static final String selectSQLUserRoles =
            "SELECT b.name FROM usersroles a join roles b on b.id=a.idrole where a.iduser=?";

    @Override
    User CreateElement(ResultSet rs) throws SQLException {
        return new User(
                rs.getInt("ID"),
                rs.getString("name"),
                rs.getString("login"),
                rs.getString("password"),
                getRoleNamesByIdUser(rs.getInt("ID"))
        );
    }

    @Override
    User CreateElement(int id) {
        User user = new User();
        user.setId(id);
        return user;
    }

    @Override
    PreparedStatement getStatementInsertSQL(User user) throws SQLException {
        PreparedStatement ps = ConnectorCreator.getConnection().prepareStatement(insertSQL, RETURN_GENERATED_KEYS);
        ps.setInt(1,user.getId());
        ps.setString(2,user.getName());
        ps.setString(3,user.getLogin());
        ps.setString(4,user.getPassword());
        return ps;
    }

    @Override
    PreparedStatement getStatementUpdateSQL(User user) throws SQLException {
        PreparedStatement ps = ConnectorCreator.getConnection().prepareStatement(updateSQL);
        ps.setString(1,user.getName());
        ps.setString(2,user.getLogin());
        ps.setString(3,user.getPassword());
        ps.setInt(4,user.getId());
        return ps;
    }

    @Override
    PreparedStatement getStatementDeleteSQL(User user) throws SQLException {
        PreparedStatement ps = ConnectorCreator.getConnection().prepareStatement(deleteSQL);
        ps.setInt(1,user.getId());
        return ps;
    }

    @Override
    PreparedStatement getStatementSelectSQL(String whereExpression) throws SQLException{
        PreparedStatement ps = ConnectorCreator.getConnection().prepareStatement(selectSQL.concat(whereExpression));
        return ps;
    }

    List<String> getRoleNamesByIdUser(int id) throws  SQLException {
        List<String> result = new ArrayList<>();
        PreparedStatement ps = ConnectorCreator.getConnection().prepareStatement(selectSQLUserRoles);
        ps.setInt(1,id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            result.add(rs.getString("name"));
        }
        return result;
    }

}