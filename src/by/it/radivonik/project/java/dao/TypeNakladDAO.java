package by.it.radivonik.project.java.dao;

import by.it.radivonik.project.java.beans.TypeNaklad;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by aleksandr.radivonik on 16.05.2017.
 */
public class TypeNakladDAO extends AbstractDAO<TypeNaklad> {
    @Override
    protected String sqlSelect() {
        return "SELECT * FROM typenaklad";
    }

    @Override
    protected String sqlInsert(TypeNaklad tpenaklad) {
        String sql = "INSERT INTO typenaklad (code, name) VALUES (%s, %s)";
        return String.format(sql, dbVal(tpenaklad.getCode()), dbVal(tpenaklad.getName()));
    }

    @Override
    protected String sqlUpdate(TypeNaklad typenklad) {
        String sql = "UPDATE typenaklad SET code = %s, name = %s WHERE id = %d";
        return String.format(sql, dbVal(typenklad.getCode()), dbVal(typenklad.getName()), typenklad.getId());
    }

    @Override
    protected String sqlDelete(TypeNaklad typenklad) {
        String sql = "DELETE FROM typenaklad WHERE id = %d";
        return String.format(sql, typenklad.getId());
    }

    @Override
    protected void setId(TypeNaklad typenklad, int id) {
        typenklad.setId(id);
    }

    @Override
    protected TypeNaklad newBean() {
        return new TypeNaklad();
    }

    @Override
    protected TypeNaklad newBean(ResultSet resultSet) throws SQLException {
        TypeNaklad typenklad = new TypeNaklad(
            resultSet.getInt("id"),
            resultSet.getString("code"),
            resultSet.getString("name"));
        return typenklad;
    }
}
