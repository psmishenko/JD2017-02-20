package by.it.loktev.jd03_03.DAO;

import java.sql.SQLException;
import java.util.List;

public interface InterfaceDAO<TYPE> {

    boolean create(TYPE entity) throws SQLException;
    TYPE read(int id) throws SQLException;
    boolean update(TYPE entity) throws SQLException;
    boolean delete(TYPE entity) throws SQLException;

    List<TYPE> getAll(String whereString) throws SQLException;
}
