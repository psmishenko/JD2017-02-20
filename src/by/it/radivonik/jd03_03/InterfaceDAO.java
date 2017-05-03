package by.it.radivonik.jd03_03;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Radivonik on 03.05.2017.
 */
public interface InterfaceDAO<T> {
    boolean create(T entity) throws SQLException;
    boolean update(T entity) throws SQLException;
    boolean delete(T entity) throws SQLException;
    List<T> getAll(String where) throws SQLException;
    T read(int id) throws SQLException;
}

