package by.it.smirnov.jd03_02.crud;

import java.sql.SQLException;

/**
 * Created by aleksey.smirnov on 01.05.2017.
 */
public interface ICrud<T> {
    boolean create(T t) throws SQLException;
    T read(T t) throws SQLException;
    boolean update(T t) throws SQLException;
    boolean delete(T t) throws SQLException;

    T readById(int id) throws SQLException;
    boolean deleteById(int id) throws SQLException;
    boolean save(T t) throws SQLException;
}
