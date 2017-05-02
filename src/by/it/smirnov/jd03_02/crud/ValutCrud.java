package by.it.smirnov.jd03_02.crud;

import by.it.smirnov.jd03_02.bean.Valut;

import java.sql.*;

import static java.sql.Statement.RETURN_GENERATED_KEYS;
import by.it.smirnov.jd03_02.Connection.ConnectorCreator;

/**
 * Created by aleksey.smirnov on 01.05.2017.
 */
public class ValutCrud extends AbstractCrud<Valut>{
    private static final String selectSQL = "SELECT `id`, `namesokr`, `namefull` FROM `valuts` WHERE ID=?";
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
    PreparedStatement getStatementSelectSQL(Valut valut) throws SQLException{
        PreparedStatement ps = ConnectorCreator.getConnection().prepareStatement(selectSQL);
        ps.setInt(1,valut.getId());
        return ps;
    }

}
