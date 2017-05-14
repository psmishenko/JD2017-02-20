package by.it.radivonik.project.java.dao;

import by.it.radivonik.project.java.connection.ConnectionCreator;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Radivonik on 03.05.2017.
 */
public abstract class AbstractDAO<T> implements InterfaceDAO<T> {
    @Override
    public boolean create(T bean) throws SQLException {
        int id = executeCreate( sqlInsert(bean));
        setId(bean, id);
        return id > 0;
    }

    @Override
    public boolean update(T bean) throws SQLException {
        return executeUpdate(sqlUpdate(bean)) == 1;
    }

    @Override
    public boolean delete(T bean) throws SQLException {
        return executeUpdate(sqlDelete(bean)) == 1;
    }

    @Override
    public List<T> getAll(String where) throws SQLException {
        final List<T> beans = new ArrayList<T>(){
            @Override
            public String toString() {
                StringBuilder res = new StringBuilder("");
                int c = 0;
                String delim = "";
                for (T bean: this) {
                    res.append(delim).append(bean);
                    delim = "\n";
                    c++;
                };
                res.append(delim).append("Итого записей: ").append(c);
                return res.toString();
            }
        };

        try (
            Connection connection = ConnectionCreator.getConnection();
            Statement statement = connection.createStatement();) {
            ResultSet resultSet = statement.executeQuery(sqlSelect()+ " " + where);
            while (resultSet.next()) {
                T bean = newBean(resultSet);
                beans.add(bean);
            }
        }
        return beans;
    }

    @Override
    public List<T> getAll(Map<String, String> filter) throws SQLException {
        String where = "";
        String delimWhere = "WHERE ";
        String delimAnd = "";
        for (Map.Entry<String, String> fieldValue: filter.entrySet()) {
            where =
                delimWhere + where + delimAnd +
                String.format("%s = '%s'", fieldValue.getKey(), fieldValue.getValue());
            delimAnd = " AND ";
            delimWhere = "";
        }
        return getAll(where);
    }

    @Override
    public T read(int id) throws SQLException {
        List<T> beans = getAll(sqlWhereId(id));
        if (beans.size() > 0)
            return beans.get(0);
        else
            return null;
    }

    protected abstract String sqlSelect();
    protected String sqlWhereId(int id) {
        return "WHERE id = " + id;
    };
    protected abstract String sqlInsert(T bean);
    protected abstract String sqlUpdate(T bean);
    protected abstract String sqlDelete(T bean);
    protected abstract void setId(T bean, int id);
    protected abstract T newBean(ResultSet resultSet) throws SQLException;

    int executeUpdate(String sql) throws SQLException {
        int res;
        try (
            Connection connection = ConnectionCreator.getConnection();
            Statement statement = connection.createStatement()) {
            res = statement.executeUpdate(sql);
        }
        return res;
    }

    int executeCreate(String sql) throws SQLException {
        int res = -1;
        try (
            Connection connection = ConnectionCreator.getConnection();
            Statement statement = connection.createStatement()) {
            if (statement.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS) == 1) {
                ResultSet keys = statement.getGeneratedKeys();
                if (keys.next())
                     res = keys.getInt(1);
            }
        }
        return res;
    }

    String dbVal(String value) {
        if (value == null || value.isEmpty())
            return "null";
        return "'" + value.replaceAll("'","''") + "'";
    }

    String dbVal(BigDecimal value) {
        if (value == null)
            return "null";
        return value.toString();
    }
}
