package by.it.smirnov.project.java.DAO;

import by.it.smirnov.project.java.Connection.ConnectorCreator;
import by.it.smirnov.project.java.bean.KursValut;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

/**
 * Created by aleksey.smirnov on 01.05.2017.
 */
public class KursValutDAO extends AbstractDAO<KursValut> {
    private static final String selectSQL = "SELECT `id`,`datekurs`,`za`,`idzavalut`,`dat`,`iddatvalut` FROM `kursvaluts`";
    private static final String countSQL = "SELECT count(*) FROM `kursvaluts`";
    private static final String insertSQL = "INSERT INTO `kursvaluts`(`id`,`datekurs`,`za`,`idzavalut`,`dat`,`iddatvalut`) VALUES (?,?,?,?,?,?);";
    private static final String updateSQL = "UPDATE `kursvaluts` SET `datekurs`=?,`za`=?,`idzavalut`=?,`dat`=?,`iddatvalut`=? WHERE ID=?";
    private static final String deleteSQL = "DELETE FROM `kursvaluts` WHERE ID=?";

    @Override
    KursValut CreateElement(ResultSet rs) throws SQLException {
        return new KursValut(
                rs.getInt("ID"),
                rs.getDate("datekurs"),
                rs.getDouble("za"),
                DAO.getInstance().getValut().read(rs.getInt("idzavalut")),
                rs.getDouble("dat"),
                DAO.getInstance().getValut().read(rs.getInt("iddatvalut"))
        );
    }

    @Override
    KursValut CreateElement(int id) {
        KursValut kursValut = new KursValut();
        kursValut.setId(id);
        return kursValut;
    }

    @Override
    PreparedStatement getStatementInsertSQL(Connection connection, KursValut kursValut) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(insertSQL, RETURN_GENERATED_KEYS);
        ps.setInt(1,kursValut.getId());
        ps.setDate(2,kursValut.getDatekurs());
        ps.setDouble(3,kursValut.getZa());
        ps.setInt(4,kursValut.getZavalut().getId());
        ps.setDouble(5,kursValut.getDat());
        ps.setInt(6,kursValut.getDatvalut().getId());
        return ps;
    }

    @Override
    PreparedStatement getStatementUpdateSQL(Connection connection, KursValut kursValut) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(updateSQL);
        ps.setDate(1,kursValut.getDatekurs());
        ps.setDouble(2,kursValut.getZa());
        ps.setInt(3,kursValut.getZavalut().getId());
        ps.setDouble(4,kursValut.getDat());
        ps.setInt(5,kursValut.getDatvalut().getId());
        ps.setInt(6,kursValut.getId());
        return ps;
    }

    @Override
    PreparedStatement getStatementDeleteSQL(Connection connection, KursValut kursValut) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(deleteSQL);
        ps.setInt(1,kursValut.getId());
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
