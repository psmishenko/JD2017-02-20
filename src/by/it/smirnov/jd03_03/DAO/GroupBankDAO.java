package by.it.smirnov.jd03_03.DAO;

import by.it.smirnov.jd03_03.Connection.ConnectorCreator;
import by.it.smirnov.jd03_03.bean.GroupBank;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

/**
 * Created by aleksey.smirnov on 01.05.2017.
 */
public class GroupBankDAO extends AbstractDAO<GroupBank> {
    private static final String selectSQL = "SELECT `id`, `name` FROM `groupsbanks`";
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
    PreparedStatement getStatementInsertSQL(GroupBank groupBank) throws SQLException {
        PreparedStatement ps = ConnectorCreator.getConnection().prepareStatement(insertSQL, RETURN_GENERATED_KEYS);
        ps.setInt(1,groupBank.getId());
        ps.setString(2,groupBank.getName());
        return ps;
    }

    @Override
    PreparedStatement getStatementUpdateSQL(GroupBank groupBank) throws SQLException {
        PreparedStatement ps = ConnectorCreator.getConnection().prepareStatement(updateSQL);
        ps.setString(1,groupBank.getName());
        ps.setInt(2,groupBank.getId());
        return ps;
    }

    @Override
    PreparedStatement getStatementDeleteSQL(GroupBank groupBank) throws SQLException {
        PreparedStatement ps = ConnectorCreator.getConnection().prepareStatement(deleteSQL);
        ps.setInt(1,groupBank.getId());
        return ps;
    }

    @Override
    PreparedStatement getStatementSelectSQL(String whereExpression) throws SQLException{
        PreparedStatement ps = ConnectorCreator.getConnection().prepareStatement(selectSQL.concat(whereExpression));
        return ps;
    }

}
