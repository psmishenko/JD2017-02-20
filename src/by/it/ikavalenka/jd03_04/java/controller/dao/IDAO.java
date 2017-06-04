package by.it.ikavalenka.jd03_04.java.controller.dao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by USER on 03.05.2017.
 */
public interface IDAO<T> {
    boolean create(T entity) throws SQLException;
    T read(int id) throws SQLException ;
    int update(T entity) throws SQLException;
    int delete(T entity) throws  SQLException;
    List<T> getAll(String whereString) throws  SQLException;

}
