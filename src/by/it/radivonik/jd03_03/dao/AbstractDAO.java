package by.it.radivonik.jd03_03.dao;

import by.it.radivonik.jd03_03.connection.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
        List<T> beans = new ArrayList<>();
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
    public T read(int id) throws SQLException {
        List<T> beans = getAll("WHERE id = " + id);
        if (beans.size() > 0)
            return beans.get(0);
        else
            return null;
    }

    protected abstract String sqlSelect();
    protected abstract String sqlInsert(T bean);
    protected abstract String sqlUpdate(T bean);
    protected abstract String sqlDelete(T bean);
    protected abstract void setId(T bean, int id);
    protected abstract T newBean(ResultSet resultSet) throws SQLException ;

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
}
