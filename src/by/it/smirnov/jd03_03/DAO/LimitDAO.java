package by.it.smirnov.jd03_03.DAO;

import by.it.smirnov.jd03_03.Connection.ConnectorCreator;
import by.it.smirnov.jd03_03.bean.Limit;

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
                rs.getInt("idgroupbank"),
                rs.getDate("fromdate"),
                rs.getInt("idopertype"),
                rs.getDouble("summa"),
                rs.getInt("idvalut"),
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
        ps.setInt(2,limit.getIdgroupbank());
        ps.setDate(3,limit.getFromdate());
        ps.setInt(4,limit.getIdopertype());
        ps.setDouble(5,limit.getSumma());
        ps.setInt(6,limit.getIdvalut());
        ps.setInt(7,limit.getIdsysoper());
        return ps;
    }

    @Override
    PreparedStatement getStatementUpdateSQL(Limit limit) throws SQLException {
        PreparedStatement ps = ConnectorCreator.getConnection().prepareStatement(updateSQL);
        ps.setInt(1,limit.getIdgroupbank());
        ps.setDate(2,limit.getFromdate());
        ps.setInt(3,limit.getIdopertype());
        ps.setDouble(4,limit.getSumma());
        ps.setInt(5,limit.getIdvalut());
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