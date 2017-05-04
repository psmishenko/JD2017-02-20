package by.it.vedom.jd03_03;

import java.sql.SQLException;
import java.util.List;

public interface InterfaceDAO<T> {
    boolean create(T entity) throws SQLException;
    T read(int id) throws SQLException;
    boolean update(T entity) throws SQLException;
    boolean delete(T entity) throws SQLException;

    List<T> getAll(String whereString) throws SQLException;
}
