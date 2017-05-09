package by.it.radivonik.project.java.dao;

import by.it.radivonik.project.java.beans.Sklad;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Radivonik on 05.05.2017.
 */
public class SkladDAO extends AbstractDAO<Sklad> {
    @Override
    protected String sqlSelect() {
        return "SELECT * FROM sklad";
    }

    @Override
    protected String sqlInsert(Sklad sklad) {
        String sql = "INSERT INTO sklad (count, cena, id_tovar, id_user) VALUES (%s, %s, %d, %d)";
        return String.format(sql, sklad.getCount(), sklad.getCena(), sklad.getIdTovar(), sklad.getIdUser());
    }

    @Override
    protected String sqlUpdate(Sklad sklad) {
        String sql = "UPDATE sklad SETcount = %s, cena = %s, id_tovar = %d, id_user = %d  WHERE id = %d";
        return String.format(sql, sklad.getCount(), sklad.getCena(), sklad.getIdTovar(), sklad.getIdUser(), sklad.getId());
    }

    @Override
    protected String sqlDelete(Sklad sklad) {
        String sql = "DELETE FROM sklad WHERE id = %d";
        return String.format(sql, sklad.getId());
    }

    @Override
    protected void setId(Sklad sklad, int id) {
        sklad.setId(id);
    }

    @Override
    protected Sklad newBean(ResultSet resultSet) throws SQLException {
        Sklad sklad = new Sklad(
            resultSet.getInt("id"),
            resultSet.getBigDecimal("count"),
            resultSet.getBigDecimal("cena"),
            resultSet.getInt("id_tovar"),
            resultSet.getInt("id_user"));
        return sklad;
    }
}
