package by.it.psmishenko.jd03_3.dao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by user on 03.05.2017.
 */
public interface InterfaceDAO<T> {
    boolean update(T entity) throws SQLException;
    boolean create(T entity)throws SQLException;
    boolean delete(T entity)throws SQLException;
    T read (int id)throws SQLException;
    List<T> getAll(String whereString)throws SQLException;
}
