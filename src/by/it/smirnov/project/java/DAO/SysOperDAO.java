package by.it.smirnov.project.java.DAO;

import by.it.smirnov.project.java.Connection.ConnectorCreator;
import by.it.smirnov.project.java.bean.SysOper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

/**
 * Created by aleksey.smirnov on 01.05.2017.
 */
public class SysOperDAO extends AbstractDAO<SysOper> {
    private static final String selectSQL = "SELECT `id`, `iduser`, `datetime` FROM `sysopers`";
    private static final String countSQL = "SELECT count(*) FROM `sysopers`";
    private static final String insertSQL = "INSERT INTO `sysopers`(`id`, `iduser`, `datetime`) VALUES (?,?,?);";
    private static final String updateSQL = "UPDATE `sysopers` SET `iduser`=?, `datetime`=? WHERE ID=?";
    private static final String deleteSQL = "DELETE FROM `sysopers` WHERE ID=?";

    @Override
    SysOper CreateElement(ResultSet rs) throws SQLException {
        return new SysOper(
                rs.getInt("ID"),
                rs.getInt("iduser"),
                rs.getTimestamp("datetime")
        );
    }

    @Override
    SysOper CreateElement(int id) {
        SysOper sysOper = new SysOper();
        sysOper.setId(id);
        return sysOper;
    }

    @Override
    PreparedStatement getStatementInsertSQL(Connection connection, SysOper sysOper) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(insertSQL, RETURN_GENERATED_KEYS);
        ps.setInt(1,sysOper.getId());
        ps.setInt(2,sysOper.getIduser());
        ps.setTimestamp(3,sysOper.getDatetime());
        return ps;
    }

    @Override
    PreparedStatement getStatementUpdateSQL(Connection connection, SysOper sysOper) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(updateSQL);
        ps.setInt(1,sysOper.getIduser());
        ps.setTimestamp(2,sysOper.getDatetime());
        ps.setInt(3,sysOper.getId());
        return ps;
    }

    @Override
    PreparedStatement getStatementDeleteSQL(Connection connection, SysOper sysOper) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(deleteSQL);
        ps.setInt(1,sysOper.getId());
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