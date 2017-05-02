package by.it.smirnov.jd03_02.crud;

import by.it.smirnov.jd03_02.Connection.ConnectorCreator;
import by.it.smirnov.jd03_02.bean.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

/**
 * Created by aleksey.smirnov on 01.05.2017.
 */
public class UserCrud extends AbstractCrud<User>{
    private static final String selectSQL = "SELECT `id`, `name`, `login`, `password` FROM `users` WHERE ID=?";
    private static final String insertSQL = "INSERT INTO `users`(`id`, `name`, `login`, `password`) VALUES (?,?,?,?);";
    private static final String updateSQL = "UPDATE `users` SET `name`=?, `login`=?, `password`=? WHERE ID=?";
    private static final String deleteSQL = "DELETE FROM `users` WHERE ID=?";

    @Override
    User CreateElement(ResultSet rs) throws SQLException {
        return new User(
                rs.getInt("ID"),
                rs.getString("name"),
                rs.getString("login"),
                rs.getString("password")
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
    PreparedStatement getStatementSelectSQL(User user) throws SQLException{
        PreparedStatement ps = ConnectorCreator.getConnection().prepareStatement(selectSQL);
        ps.setInt(1,user.getId());
        return ps;
    }

}