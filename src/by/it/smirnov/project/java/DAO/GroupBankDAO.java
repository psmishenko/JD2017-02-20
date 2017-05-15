package by.it.smirnov.project.java.DAO;

import by.it.smirnov.project.java.Connection.ConnectorCreator;
import by.it.smirnov.project.java.bean.GroupBank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

/**
 * Created by aleksey.smirnov on 01.05.2017.
 */
public class GroupBankDAO extends AbstractDAO<GroupBank> {
    private static final String selectSQL = "SELECT `id`, `name` FROM `groupsbanks`";
    private static final String countSQL = "SELECT count(*) FROM `groupsbanks`";
    private static final String insertSQL = "INSERT INTO `groupsbanks`(`id`, `name`) VALUES (?,?);";
    private static final String updateSQL = "UPDATE `groupsbanks` SET `name`=? WHERE ID=?";
    private static final String deleteSQL = "DELETE FROM `groupsbanks` WHERE ID=?";

    @Override
    GroupBank CreateElement(ResultSet rs) throws SQLException {
        return new GroupBank(
                rs.getInt("ID"),
                rs.getString("name")
        );
    }

    @Override
    GroupBank CreateElement(int id) {
        GroupBank groupBank = new GroupBank();
        groupBank.setId(id);
        return groupBank;
    }

    @Override
    PreparedStatement getStatementInsertSQL(Connection connection, GroupBank groupBank) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(insertSQL, RETURN_GENERATED_KEYS);
        ps.setInt(1,groupBank.getId());
        ps.setString(2,groupBank.getName());
        return ps;
    }

    @Override
    PreparedStatement getStatementUpdateSQL(Connection connection, GroupBank groupBank) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(updateSQL);
        ps.setString(1,groupBank.getName());
        ps.setInt(2,groupBank.getId());
        return ps;
    }

    @Override
    PreparedStatement getStatementDeleteSQL(Connection connection, GroupBank groupBank) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(deleteSQL);
        ps.setInt(1,groupBank.getId());
        return ps;
    }

    @Override
    PreparedStatement getStatementSelectSQL(Connection connection, String whereExpression) throws SQLException{
        PreparedStatement ps = connection.prepareStatement(selectSQL.concat(whereExpression));
        return ps;
    }

    @Override
    PreparedStatement getStatementCountSQL(Connection connection, String whereExpression) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(countSQL.concat(whereExpression));
        return ps;
    }


}
