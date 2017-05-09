package by.it.radivonik.project.java.dao;

import by.it.radivonik.project.java.beans.Naklad;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Radivonik on 05.05.2017.
 */
public class NakladDAO extends AbstractDAO<Naklad> {
    @Override
    protected String sqlSelect() {
        return "SELECT * FROM naklad";
    }

    @Override
    protected String sqlInsert(Naklad naklad) {
        String sql =
            "INSERT INTO naklad (date, num, seria, id_user, id_type, id_avto, id_klient) VALUES (" +
            "'%s', '%s', '%s', %d, %d, %d, %d)";
        return String.format(
            sql, naklad.getDate(), naklad.getNum(), naklad.getSeria(),
            naklad.getIdUser(), naklad.getIdType(), naklad.getIdKlient(), naklad.getIdAvto());
    }

    @Override
    protected String sqlUpdate(Naklad naklad) {
        String sql =
            "UPDATE naklad SET date = '%s', num = '%s', seria = '%s', " +
            "id_user = %d, id_type = %d, id_avto = %d, id_klient =%d WHERE id = %d";
        return String.format(
            sql, naklad.getDate(), naklad.getNum(), naklad.getSeria(),
            naklad.getIdUser(), naklad.getIdType(), naklad.getIdKlient(), naklad.getIdAvto(), naklad.getId());
    }

    @Override
    protected String sqlDelete(Naklad naklad) {
        String sql = "DELETE FROM naklad WHERE id = %d";
        return String.format(sql, naklad.getId());
    }


    @Override
    protected void setId(Naklad naklad, int id) {
        naklad.setId(id);
    }

    @Override
    protected Naklad newBean(ResultSet resultSet) throws SQLException {
        Naklad naklad = new Naklad(
            resultSet.getInt("id"),
            resultSet.getDate("date"),
            resultSet.getString("num"),
            resultSet.getString("seria"),
            resultSet.getInt("id_user"),
            resultSet.getInt("id_type"),
            resultSet.getInt("id_klient"),
            resultSet.getInt("id_naklad"));
        return naklad;
    }
}
