package by.it.radivonik.jd03_03.dao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Radivonik on 03.05.2017.
 */
public interface InterfaceDAO<T> {
    boolean create(T bean) throws SQLException;
    boolean update(T bean) throws SQLException;
    boolean delete(T bean) throws SQLException;
    List<T> getAll(String where) throws SQLException;
    T read(int id) throws SQLException;
}

