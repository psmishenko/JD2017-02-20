package by.it.radivonik.jd03_03.dao;

import by.it.radivonik.jd03_03.beans.Klient;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Radivonik on 04.05.2017.
 */
public class KlientDAO extends AbstractDAO<Klient>{
    @Override
    protected String sqlSelect() {
        return "SELECT * FROM klient";
    }

    @Override
    protected String sqlInsert(Klient klient) {
        String sql = "INSERT INTO klient (name, unp, adres) VALUES ('%s', '%s', '%s')";
        return String.format(sql, klient.getName(), klient.getUnp(), klient.getAdres());
    }

    @Override
    protected String sqlUpdate(Klient klient) {
        String sql = "UPDATE klient SET name = '%s', unp = '%s', adres = '%s' WHERE id = %d";
        return String.format(sql, klient.getName(), klient.getUnp(), klient.getAdres(), klient.getId());
    }

    @Override
    protected String sqlDelete(Klient klient) {
        String sql = "DELETE FROM klient WHERE id = %d";
        return String.format(sql, klient.getId());
    }


    @Override
    protected void setId(Klient klient, int id) {
        klient.setId(id);
    }

    @Override
    protected Klient newBean(ResultSet resultSet) throws SQLException {
        Klient klient = new Klient(
            resultSet.getInt("id"),
            resultSet.getString("name"),
            resultSet.getString("unp"),
            resultSet.getString("adres"));
        return klient;
    }
}
