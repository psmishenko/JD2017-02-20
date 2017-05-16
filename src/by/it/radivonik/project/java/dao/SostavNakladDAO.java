package by.it.radivonik.project.java.dao;

import by.it.radivonik.project.java.beans.SostavNaklad;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Radivonik on 05.05.2017.
 */
public class SostavNakladDAO extends AbstractDAO<SostavNaklad> {
    @Override
    protected String sqlSelect() {
        return "SELECT * FROM sostavnaklad";
    }

    @Override
    protected String sqlInsert(SostavNaklad sostavnaklad) {
        String sql =
            "INSERT INTO sostavnaklad (npp, count, cena, prnds, id_naklad, id_tovar) VALUES (" +
            "%d, %s, %s, %s, %d, %d)";
        return String.format(
            sql, sostavnaklad.getNpp(), sostavnaklad.getCount(), sostavnaklad.getCena(),
            sostavnaklad.getPrnds(), sostavnaklad.getIdNaklad(), sostavnaklad.getIdTovar());
    }

    @Override
    protected String sqlUpdate(SostavNaklad sostavnaklad) {
        String sql =
            "UPDATE sostavnaklad SET npp = %d, count = %s, cena = %s, " +
            "prnds = %s, id_naklad = %d, id_tovar = %d WHERE id = %d";
        return String.format(
            sql, sostavnaklad.getNpp(), sostavnaklad.getCount(), sostavnaklad.getCena(),
            sostavnaklad.getPrnds(), sostavnaklad.getIdNaklad(), sostavnaklad.getIdTovar(), sostavnaklad.getId());
    }

    @Override
    protected String sqlDelete(SostavNaklad sostavnaklad) {
        String sql = "DELETE FROM sostavnaklad WHERE id = %d";
        return String.format(sql, sostavnaklad.getId());
    }

    @Override
    protected void setId(SostavNaklad sostavnaklad, int id) {
        sostavnaklad.setId(id);
    }

    @Override
    protected SostavNaklad newBean() {
        return new SostavNaklad();
    }

    @Override
    protected SostavNaklad newBean(ResultSet resultSet) throws SQLException {
        SostavNaklad sostavnaklad = new SostavNaklad(
            resultSet.getInt("id"),
            resultSet.getInt("npp"),
            resultSet.getBigDecimal("count"),
            resultSet.getBigDecimal("cena"),
            resultSet.getBigDecimal("prnds"),
            resultSet.getInt("id_naklad"),
            resultSet.getInt("id_tovar"));
        return sostavnaklad;
    }
}
