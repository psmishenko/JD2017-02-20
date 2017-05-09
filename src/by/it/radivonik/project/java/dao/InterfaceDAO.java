package by.it.radivonik.project.java.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Radivonik on 03.05.2017.
 */
public interface InterfaceDAO<T> {
    boolean create(T bean) throws SQLException;
    boolean update(T bean) throws SQLException;
    boolean delete(T bean) throws SQLException;
    List<T> getAll(String where) throws SQLException;
    List<T> getAll(Map<String,String> filter) throws SQLException;
    T read(int id) throws SQLException;
}

