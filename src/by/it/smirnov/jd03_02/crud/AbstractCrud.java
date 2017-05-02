package by.it.smirnov.jd03_02.crud;

import java.sql.*;
import by.it.smirnov.jd03_02.bean.AbstractBaseClass;

/**
 * Created by aleksey.smirnov on 01.05.2017.
 */
public abstract class AbstractCrud<T> implements ICrud<T>{

    abstract PreparedStatement getStatementInsertSQL(T t) throws SQLException;
    abstract PreparedStatement getStatementUpdateSQL(T t) throws SQLException;
    abstract PreparedStatement getStatementDeleteSQL(T t) throws SQLException;
    abstract PreparedStatement getStatementSelectSQL(T t) throws SQLException;
    abstract T CreateElement(ResultSet rs) throws SQLException;
    abstract T CreateElement(int id);

    @Override
    public boolean create(T t) throws SQLException {
        try (PreparedStatement statement = getStatementInsertSQL(t)) {
            if (statement.executeUpdate() == 1) {
                ResultSet keys = statement.getGeneratedKeys();
                if (keys.next()) {
                    int id = keys.getInt(1);
                    ((AbstractBaseClass)t).setId(id);
                    return true;
                }
            }
            return false;
        }
    }

    @Override
    public boolean update(T t) throws SQLException {
        try (PreparedStatement statement = getStatementUpdateSQL(t)) {
            return (1 == statement.executeUpdate());
        }
    }

    @Override
    public boolean delete(T t) throws SQLException {
        try (PreparedStatement statement = getStatementDeleteSQL(t)) {
            return (1 == statement.executeUpdate());
        }
    }

    @Override
    public T read(T t) throws SQLException {
        T result = null;
        try (PreparedStatement statement = getStatementSelectSQL(t)) {
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                result = CreateElement(rs);
            }
        }
        return result;

    }

    @Override
    public T readById(int id) throws SQLException{
        return read(CreateElement(id));
    }

    @Override
    public boolean deleteById(int id) throws SQLException {
        return delete(CreateElement(id));
    }

    @Override
    public boolean save(T t) throws SQLException {
        boolean result=false;
        if (t instanceof AbstractBaseClass){
            if (((AbstractBaseClass)t).getId()==0)
                result = create(t);
            else
                result = update(t);
        }
        return result;
    }
}
