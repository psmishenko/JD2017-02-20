package by.it.smirnov.jd03_03.DAO;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by aleksey.smirnov on 01.05.2017.
 */
public interface IDAO<T> {
    boolean create(T t) throws SQLException;
    T read(int id) throws SQLException;
    boolean update(T t) throws SQLException;
    boolean delete(T t) throws SQLException;

    boolean deleteById(int id) throws SQLException;
    boolean save(T t) throws SQLException;

    List<T> getAll(String whereExpression) throws SQLException;
}
