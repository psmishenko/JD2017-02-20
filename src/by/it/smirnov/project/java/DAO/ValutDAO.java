package by.it.smirnov.project.java.DAO;

import by.it.smirnov.project.java.Connection.ConnectorCreator;
import by.it.smirnov.project.java.bean.Valut;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

/**
 * Created by aleksey.smirnov on 01.05.2017.
 */
public class ValutDAO extends AbstractDAO<Valut> {
    private static final String selectSQL = "SELECT `id`, `namesokr`, `namefull` FROM `valuts`";
    private static final String countSQL = "SELECT count(*) FROM `valuts`";
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
    PreparedStatement getStatementInsertSQL(Connection connection, Valut valut) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(insertSQL, RETURN_GENERATED_KEYS);
        ps.setInt(1,valut.getId());
        ps.setString(2,valut.getNamesokr());
        ps.setString(3,valut.getNamefull());
        return ps;
    }

    @Override
    PreparedStatement getStatementUpdateSQL(Connection connection, Valut valut) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(updateSQL);
        ps.setString(1,valut.getNamesokr());
        ps.setString(2,valut.getNamefull());
        ps.setInt(3,valut.getId());
        return ps;
    }

    @Override
    PreparedStatement getStatementDeleteSQL(Connection connection, Valut valut) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(deleteSQL);
        ps.setInt(1,valut.getId());
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
