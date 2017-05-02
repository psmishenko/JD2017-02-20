package by.it.smirnov.jd03_02.crud;

import by.it.smirnov.jd03_02.Connection.ConnectorCreator;
import by.it.smirnov.jd03_02.bean.SysOper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

/**
 * Created by aleksey.smirnov on 01.05.2017.
 */
public class SysOperCrud extends AbstractCrud<SysOper>{
    private static final String selectSQL = "SELECT `id`, `iduser`, `datetime` FROM `sysopers` WHERE ID=?";
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
    PreparedStatement getStatementInsertSQL(SysOper sysOper) throws SQLException {
        PreparedStatement ps = ConnectorCreator.getConnection().prepareStatement(insertSQL, RETURN_GENERATED_KEYS);
        ps.setInt(1,sysOper.getId());
        ps.setInt(2,sysOper.getIduser());
        ps.setTimestamp(3,sysOper.getDatetime());
        return ps;
    }

    @Override
    PreparedStatement getStatementUpdateSQL(SysOper sysOper) throws SQLException {
        PreparedStatement ps = ConnectorCreator.getConnection().prepareStatement(updateSQL);
        ps.setInt(1,sysOper.getIduser());
        ps.setTimestamp(2,sysOper.getDatetime());
        ps.setInt(3,sysOper.getId());
        return ps;
    }

    @Override
    PreparedStatement getStatementDeleteSQL(SysOper sysOper) throws SQLException {
        PreparedStatement ps = ConnectorCreator.getConnection().prepareStatement(deleteSQL);
        ps.setInt(1,sysOper.getId());
        return ps;
    }

    @Override
    PreparedStatement getStatementSelectSQL(SysOper sysOper) throws SQLException{
        PreparedStatement ps = ConnectorCreator.getConnection().prepareStatement(selectSQL);
        ps.setInt(1,sysOper.getId());
        return ps;
    }

}