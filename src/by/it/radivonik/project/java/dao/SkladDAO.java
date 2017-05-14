package by.it.radivonik.project.java.dao;

import by.it.radivonik.project.java.beans.Sklad;
import by.it.radivonik.project.java.beans.Tovar;
import by.it.radivonik.project.java.beans.User;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Radivonik on 05.05.2017.
 */
public class SkladDAO extends AbstractDAO<Sklad> {
    @Override
    protected String sqlSelect() {
        return "SELECT a0.*, ROUND(a0.count*a0.cena,2) AS stoim FROM sklad a0";
    }

    @Override
    protected String sqlInsert(Sklad sklad) {
        String sql = "INSERT INTO sklad (count, cena, id_tovar, id_user) VALUES (%s, %s, %d, %d)";
        return String.format(
            sql,
            dbVal(sklad.getCount()),
            dbVal(sklad.getCena()),
            sklad.getTovar().getId(),
            sklad.getUser().getId());
    }

    @Override
    protected String sqlUpdate(Sklad sklad) {
        String sql = "UPDATE sklad SET count = %s, cena = %s, id_tovar = %d, id_user = %d  WHERE id = %d";
        return String.format(
            sql,
            dbVal(sklad.getCount()),
            dbVal(sklad.getCena()),
            sklad.getTovar().getId(),
            sklad.getUser().getId(),
            sklad.getId());
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
        int idTovar = resultSet.getInt("id_tovar");
        int idUser = resultSet.getInt("id_user");
        Sklad sklad = new Sklad(
            resultSet.getInt("id"),
            resultSet.getBigDecimal("count"),
            resultSet.getBigDecimal("cena"),
            null,
            null,
            resultSet.getBigDecimal("stoim"));
        sklad.setTovar(DAO.getInstance().getTovar().read(idTovar));
        sklad.setUser(DAO.getInstance().getUser().read(idUser));
        return sklad;
    }
}
