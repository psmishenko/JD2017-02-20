package by.it.smirnov.jd03_03.DAO;

import by.it.smirnov.jd03_03.Connection.ConnectorCreator;
import by.it.smirnov.jd03_03.bean.OperType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

/**
 * Created by aleksey.smirnov on 01.05.2017.
 */
public class OperTypeDAO extends AbstractDAO<OperType> {
    private static final String selectSQL = "SELECT `id`, `name` FROM `opertypes`";
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
    PreparedStatement getStatementSelectSQL(String whereExpression) throws SQLException{
        PreparedStatement ps = ConnectorCreator.getConnection().prepareStatement(selectSQL.concat(whereExpression));
        return ps;
    }

}

