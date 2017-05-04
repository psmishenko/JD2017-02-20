package by.it.radivonik.jd03_03.dao;

import by.it.radivonik.jd03_03.beans.Tovar;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Radivonik on 04.05.2017.
 */
public class TovarDAO extends AbstractDAO<Tovar> implements InterfaceDAO<Tovar> {
    @Override
    protected String sqlSelect() {
        return "SELECT * FROM tovar";
    }

    @Override
    protected String sqlInsert(Tovar tovar) {
        String sql = "INSERT INTO tovar (name, edizm) VALUES ('%s', '%s')";
        return String.format(sql, tovar.getName(), tovar.getEdizm());
    }

    @Override
    protected String sqlUpdate(Tovar tovar) {
        String sql = "UPDATE tovar SET name = '%s', edizm = '%s' WHERE id = %d";
        return String.format(sql, tovar.getName(), tovar.getEdizm(), tovar.getId());
    }

    @Override
    protected String sqlDelete(Tovar tovar) {
        String sql = "DELETE FROM tovar WHERE id = %d";
        return String.format(sql, tovar.getId());
    }


    @Override
    protected void setId(Tovar tovar, int id) {
        tovar.setId(id);
    }

    @Override
    protected Tovar newBean(ResultSet resultSet) throws SQLException {
        Tovar tovar = new Tovar(
            resultSet.getInt("id"),
            resultSet.getString("name"),
            resultSet.getString("edizm"));
        return tovar;
    }
}
