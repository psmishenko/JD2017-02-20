package by.it.smirnov.project.java.DAO;

import by.it.smirnov.project.java.Connection.ConnectorCreator;
import by.it.smirnov.project.java.bean.AbstractBaseClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by aleksey.smirnov on 01.05.2017.
 */
public abstract class AbstractDAO<T> implements IDAO<T> {

    abstract PreparedStatement getStatementInsertSQL(Connection connection, T t) throws SQLException;
    abstract PreparedStatement getStatementUpdateSQL(Connection connection, T t) throws SQLException;
    abstract PreparedStatement getStatementDeleteSQL(Connection connection, T t) throws SQLException;
    abstract PreparedStatement getStatementSelectSQL(Connection connection, String whereExpression) throws SQLException;
    abstract PreparedStatement getStatementCountSQL(Connection connection, String whereExpression) throws SQLException;
    abstract T CreateElement(ResultSet rs) throws SQLException;
    abstract T CreateElement(int id);

    @Override
    public boolean create(T t) throws SQLException {
        try (Connection connection = ConnectorCreator.getConnection();
             PreparedStatement statement = getStatementInsertSQL(connection, t)){
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
        try (Connection connection = ConnectorCreator.getConnection();
             PreparedStatement statement = getStatementUpdateSQL(connection, t)) {
            return (1 == statement.executeUpdate());
        }
    }

    @Override
    public boolean delete(T t) throws SQLException {
        try (Connection connection = ConnectorCreator.getConnection();
             PreparedStatement statement = getStatementDeleteSQL(connection, t)) {
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
        try (Connection connection = ConnectorCreator.getConnection();
             PreparedStatement statement = getStatementSelectSQL(connection, whereExpression)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                result.add(CreateElement(rs));
            }
        }
        return result;
    }

    @Override
    public int getCount(String whereExpression) throws SQLException {
        try (Connection connection = ConnectorCreator.getConnection();
             PreparedStatement statement = getStatementCountSQL(connection, whereExpression)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        }
        return 0;
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
