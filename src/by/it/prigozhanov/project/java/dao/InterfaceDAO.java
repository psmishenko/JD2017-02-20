package by.it.prigozhanov.project.java.dao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by v-omf on 5/3/2017!
 */
public interface InterfaceDAO<T> {

    boolean create(T entity) throws SQLException;
    T read(int id) throws SQLException;
    boolean update(T entity) throws SQLException;
    boolean delete(T entity) throws SQLException;

    List<T> getAll(String whereString) throws SQLException;



}
