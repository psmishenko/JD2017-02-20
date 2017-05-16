package by.it.smirnov.project.java.DAO;

import by.it.smirnov.project.java.Connection.ConnectorCreator;
import by.it.smirnov.project.java.bean.OperType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

/**
 * Created by aleksey.smirnov on 01.05.2017.
 */
public class OperTypeDAO extends AbstractDAO<OperType> {
    private static final String selectSQL = "SELECT `id`, `name` FROM `opertypes`";
    private static final String countSQL = "SELECT count(*) FROM `opertypes`";
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
    PreparedStatement getStatementInsertSQL(Connection connection, OperType operType) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(insertSQL, RETURN_GENERATED_KEYS);
        ps.setInt(1,operType.getId());
        ps.setString(2,operType.getName());
        return ps;
    }

    @Override
    PreparedStatement getStatementUpdateSQL(Connection connection, OperType operType) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(updateSQL);
        ps.setString(1,operType.getName());
        ps.setInt(2,operType.getId());
        return ps;
    }

    @Override
    PreparedStatement getStatementDeleteSQL(Connection connection, OperType operType) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(deleteSQL);
        ps.setInt(1,operType.getId());
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

