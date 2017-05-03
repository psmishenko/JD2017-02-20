package by.it.smirnov.jd03_03.DAO;

import by.it.smirnov.jd03_03.bean.AbstractBaseClass;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by aleksey.smirnov on 01.05.2017.
 */
public abstract class AbstractDAO<T> implements IDAO<T> {

    abstract PreparedStatement getStatementInsertSQL(T t) throws SQLException;
    abstract PreparedStatement getStatementUpdateSQL(T t) throws SQLException;
    abstract PreparedStatement getStatementDeleteSQL(T t) throws SQLException;
    abstract PreparedStatement getStatementSelectSQL(String whereExpression) throws SQLException;
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
    public T read(int id) throws SQLException {
        T result = null;
        List<T> list=getAll(String.format(" WHERE ID=%d",id));
        if (list.size()==1){
            result = list.get(0);
        }
        return result;
    }

    @Override
    public List<T> getAll(String whereExpression) throws SQLException {
        List<T> result = new ArrayList<>();
        try (PreparedStatement statement = getStatementSelectSQL(whereExpression)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                result.add(CreateElement(rs));
            }
        }
        return result;
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
