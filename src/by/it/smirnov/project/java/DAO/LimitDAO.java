package by.it.smirnov.project.java.DAO;

import by.it.smirnov.project.java.Connection.ConnectorCreator;
import by.it.smirnov.project.java.bean.Limit;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

/**
 * Created by aleksey.smirnov on 01.05.2017.
 */
public class LimitDAO extends AbstractDAO<Limit> {
    private static final String selectSQL = "SELECT `id`,`idgroupbank`,`fromdate`,`idopertype`,`summa`,`idvalut`,`idsysoper` FROM `limits`";
    private static final String insertSQL = "INSERT INTO `limits`(`id`,`idgroupbank`,`fromdate`,`idopertype`,`summa`,`idvalut`,`idsysoper`) VALUES (?,?,?,?,?,?,?);";
    private static final String updateSQL = "UPDATE `limits` SET `idgroupbank`=?,`fromdate`=?,`idopertype`=?,`summa`=?,`idvalut`=?,`idsysoper`=? WHERE ID=?";
    private static final String deleteSQL = "DELETE FROM `limits` WHERE ID=?";

    @Override
    Limit CreateElement(ResultSet rs) throws SQLException {
        return new Limit(
                rs.getInt("ID"),
                DAO.getInstance().getGroupBank().read(rs.getInt("idgroupbank")),
                rs.getDate("fromdate"),
                DAO.getInstance().getOperType().read(rs.getInt("idopertype")),
                rs.getDouble("summa"),
                DAO.getInstance().getValut().read(rs.getInt("idvalut")),
                rs.getInt("idsysoper")
        );
    }

    @Override
    Limit CreateElement(int id) {
        Limit limit = new Limit();
        limit.setId(id);
        return limit;
    }

    @Override
    PreparedStatement getStatementInsertSQL(Limit limit) throws SQLException {
        PreparedStatement ps = ConnectorCreator.getConnection().prepareStatement(insertSQL, RETURN_GENERATED_KEYS);
        ps.setInt(1,limit.getId());
        ps.setInt(2,limit.getGroupbank().getId());
        ps.setDate(3,limit.getFromdate());
        ps.setInt(4,limit.getOpertype().getId());
        ps.setDouble(5,limit.getSumma());
        ps.setInt(6,limit.getValut().getId());
        ps.setInt(7,limit.getIdsysoper());
        return ps;
    }

    @Override
    PreparedStatement getStatementUpdateSQL(Limit limit) throws SQLException {
        PreparedStatement ps = ConnectorCreator.getConnection().prepareStatement(updateSQL);
        ps.setInt(1,limit.getGroupbank().getId());
        ps.setDate(2,limit.getFromdate());
        ps.setInt(3,limit.getOpertype().getId());
        ps.setDouble(4,limit.getSumma());
        ps.setInt(5,limit.getValut().getId());
        ps.setInt(6,limit.getIdsysoper());
        ps.setInt(7,limit.getId());
        return ps;
    }

    @Override
    PreparedStatement getStatementDeleteSQL(Limit limit) throws SQLException {
        PreparedStatement ps = ConnectorCreator.getConnection().prepareStatement(deleteSQL);
        ps.setInt(1,limit.getId());
        return ps;
    }

    @Override
    PreparedStatement getStatementSelectSQL(String whereExpression) throws SQLException{
        PreparedStatement ps = ConnectorCreator.getConnection().prepareStatement(selectSQL.concat(whereExpression));
        return ps;
    }

}