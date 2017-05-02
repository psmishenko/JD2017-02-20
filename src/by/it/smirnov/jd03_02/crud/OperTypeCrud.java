package by.it.smirnov.jd03_02.crud;

import by.it.smirnov.jd03_02.Connection.ConnectorCreator;
import by.it.smirnov.jd03_02.bean.OperType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

/**
 * Created by aleksey.smirnov on 01.05.2017.
 */
public class OperTypeCrud extends AbstractCrud<OperType>{
    private static final String selectSQL = "SELECT `id`, `name` FROM `opertypes` WHERE ID=?";
    private static final String insertSQL = "INSERT INTO `opertypes`(`id`, `name`) VALUES (?,?);";
    private static final String updateSQL = "UPDATE `opertypes` SET `name`=? WHERE ID=?";
    private static final String deleteSQL = "DELETE FROM `opertypes` WHERE ID=?";

    @Override
    OperType CreateElement(ResultSet rs) throws SQLException {
        return new OperType(
                rs.getInt("ID"),
                rs.getString("name")
        );
    }

    @Override
    OperType CreateElement(int id) {
        OperType operType = new OperType();
        operType.setId(id);
        return operType;
    }

    @Override
    PreparedStatement getStatementInsertSQL(OperType operType) throws SQLException {
        PreparedStatement ps = ConnectorCreator.getConnection().prepareStatement(insertSQL, RETURN_GENERATED_KEYS);
        ps.setInt(1,operType.getId());
        ps.setString(2,operType.getName());
        return ps;
    }

    @Override
    PreparedStatement getStatementUpdateSQL(OperType operType) throws SQLException {
        PreparedStatement ps = ConnectorCreator.getConnection().prepareStatement(updateSQL);
        ps.setString(1,operType.getName());
        ps.setInt(2,operType.getId());
        return ps;
    }

    @Override
    PreparedStatement getStatementDeleteSQL(OperType operType) throws SQLException {
        PreparedStatement ps = ConnectorCreator.getConnection().prepareStatement(deleteSQL);
        ps.setInt(1,operType.getId());
        return ps;
    }

    @Override
    PreparedStatement getStatementSelectSQL(OperType operType) throws SQLException{
        PreparedStatement ps = ConnectorCreator.getConnection().prepareStatement(selectSQL);
        ps.setInt(1,operType.getId());
        return ps;
    }

}

