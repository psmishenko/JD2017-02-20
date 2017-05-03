package by.it.smirnov.jd03_03.DAO;

import by.it.smirnov.jd03_03.Connection.ConnectorCreator;
import by.it.smirnov.jd03_03.bean.Valut;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

/**
 * Created by aleksey.smirnov on 01.05.2017.
 */
public class ValutDAO extends AbstractDAO<Valut> {
    private static final String selectSQL = "SELECT `id`, `namesokr`, `namefull` FROM `valuts`";
    private static final String insertSQL = "INSERT INTO `valuts`(`id`, `namesokr`, `namefull`) VALUES (?,?,?);";
    private static final String updateSQL = "UPDATE `valuts` SET `namesokr`=?, `namefull`=? WHERE ID=?";
    private static final String deleteSQL = "DELETE FROM `valuts` WHERE ID=?";

    @Override
    Valut CreateElement(ResultSet rs) throws SQLException {
        return new Valut(
                rs.getInt("ID"),
                rs.getString("namesokr"),
                rs.getString("namefull")
        );
    }

    @Override
    Valut CreateElement(int id) {
        Valut valut = new Valut();
        valut.setId(id);
        return valut;
    }

    @Override
    PreparedStatement getStatementInsertSQL(Valut valut) throws SQLException {
        PreparedStatement ps = ConnectorCreator.getConnection().prepareStatement(insertSQL, RETURN_GENERATED_KEYS);
        ps.setInt(1,valut.getId());
        ps.setString(2,valut.getNamesokr());
        ps.setString(3,valut.getNamefull());
        return ps;
    }

    @Override
    PreparedStatement getStatementUpdateSQL(Valut valut) throws SQLException {
        PreparedStatement ps = ConnectorCreator.getConnection().prepareStatement(updateSQL);
        ps.setString(1,valut.getNamesokr());
        ps.setString(2,valut.getNamefull());
        ps.setInt(3,valut.getId());
        return ps;
    }

    @Override
    PreparedStatement getStatementDeleteSQL(Valut valut) throws SQLException {
        PreparedStatement ps = ConnectorCreator.getConnection().prepareStatement(deleteSQL);
        ps.setInt(1,valut.getId());
        return ps;
    }

    @Override
    PreparedStatement getStatementSelectSQL(String whereExpression) throws SQLException{
        PreparedStatement ps = ConnectorCreator.getConnection().prepareStatement(selectSQL.concat(whereExpression));
        return ps;
    }

}
