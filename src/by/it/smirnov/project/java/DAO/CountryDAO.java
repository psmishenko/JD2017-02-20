package by.it.smirnov.project.java.DAO;

import by.it.smirnov.project.java.Connection.ConnectorCreator;
import by.it.smirnov.project.java.bean.Country;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

/**
 * Created by aleksey.smirnov on 01.05.2017.
 */
public class CountryDAO extends AbstractDAO<Country> {
    private static final String selectSQL = "SELECT `id`, `name` FROM `countrys`";
    private static final String countSQL = "SELECT count(*) FROM `countrys`";
    private static final String insertSQL = "INSERT INTO `countrys`(`id`, `name`) VALUES (?,?);";
    private static final String updateSQL = "UPDATE `countrys` SET `name`=? WHERE ID=?";
    private static final String deleteSQL = "DELETE FROM `countrys` WHERE ID=?";

    @Override
    Country CreateElement(ResultSet rs) throws SQLException {
        return new Country(
                rs.getInt("ID"),
                rs.getString("name")
        );
    }

    @Override
    Country CreateElement(int id) {
        Country country = new Country();
        country.setId(id);
        return country;
    }

    @Override
    PreparedStatement getStatementInsertSQL(Connection connection, Country country) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(insertSQL, RETURN_GENERATED_KEYS);
        ps.setInt(1,country.getId());
        ps.setString(2,country.getName());
        return ps;
    }

    @Override
    PreparedStatement getStatementUpdateSQL(Connection connection, Country country) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(updateSQL);
        ps.setString(1,country.getName());
        ps.setInt(2,country.getId());
        return ps;
    }

    @Override
    PreparedStatement getStatementDeleteSQL(Connection connection, Country country) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(deleteSQL);
        ps.setInt(1,country.getId());
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
