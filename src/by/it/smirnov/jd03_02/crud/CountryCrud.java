package by.it.smirnov.jd03_02.crud;

import by.it.smirnov.jd03_02.Connection.ConnectorCreator;
import by.it.smirnov.jd03_02.bean.Country;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

/**
 * Created by aleksey.smirnov on 01.05.2017.
 */
public class CountryCrud extends AbstractCrud<Country>{
    private static final String selectSQL = "SELECT `id`, `name` FROM `countrys` WHERE ID=?";
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
    PreparedStatement getStatementInsertSQL(Country country) throws SQLException {
        PreparedStatement ps = ConnectorCreator.getConnection().prepareStatement(insertSQL, RETURN_GENERATED_KEYS);
        ps.setInt(1,country.getId());
        ps.setString(2,country.getName());
        return ps;
    }

    @Override
    PreparedStatement getStatementUpdateSQL(Country country) throws SQLException {
        PreparedStatement ps = ConnectorCreator.getConnection().prepareStatement(updateSQL);
        ps.setString(1,country.getName());
        ps.setInt(2,country.getId());
        return ps;
    }

    @Override
    PreparedStatement getStatementDeleteSQL(Country country) throws SQLException {
        PreparedStatement ps = ConnectorCreator.getConnection().prepareStatement(deleteSQL);
        ps.setInt(1,country.getId());
        return ps;
    }

    @Override
    PreparedStatement getStatementSelectSQL(Country country) throws SQLException{
        PreparedStatement ps = ConnectorCreator.getConnection().prepareStatement(selectSQL);
        ps.setInt(1,country.getId());
        return ps;
    }

}
