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
            "INSERT INTO naklad (date, num, seria, id_user, id_type, id_klient, id_avto) VALUES (" +
            "%s, %s, %s, %s, %s, %s, %s)";
        return String.format(
            sql, dbVal(naklad.getDate()), dbVal(naklad.getNum()), dbVal(naklad.getSeria()),
            dbVal(naklad.getUser().getId()), dbVal(naklad.getType().getId()),
            dbVal(naklad.getKlient().getId()), dbVal(naklad.getAvto().getId()));
    }

    @Override
    protected String sqlUpdate(Naklad naklad) {
        String sql =
            "UPDATE naklad SET date = %s, num = %s, seria = %s, " +
            "id_user = %s, id_type = %s, id_klient = %s, id_avto = %s WHERE id = %d";
        return String.format(
            sql, dbVal(naklad.getDate()), dbVal(naklad.getNum()), dbVal(naklad.getSeria()),
            dbVal(naklad.getUser().getId()), dbVal(naklad.getType().getId()),
            dbVal(naklad.getKlient().getId()), dbVal(naklad.getAvto().getId()),
            naklad.getId());
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
    protected Naklad newBean() {
        return new Naklad();
    }

    @Override
    protected Naklad newBean(ResultSet resultSet) throws SQLException {
       return new Naklad(
            resultSet.getInt("id"),
            resultSet.getDate("date"),
            resultSet.getString("num"),
            resultSet.getString("seria"),
            DAO.getInstance().getUser().read(resultSet.getInt("id_user")),
            DAO.getInstance().getTypeNaklad().read(resultSet.getInt("id_type")),
            DAO.getInstance().getKlient().read(resultSet.getInt("id_klient")),
            DAO.getInstance().getAvto().read(resultSet.getInt("id_avto")));
    }
}
