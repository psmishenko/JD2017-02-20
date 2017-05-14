package by.it.loktev.project.java.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface InterfaceDAO<TYPE> {

    boolean create(TYPE entity) throws SQLException;
    TYPE read(int id) throws SQLException;
    boolean update(TYPE entity) throws SQLException;
    boolean delete(TYPE entity) throws SQLException;

    List<TYPE> getAll(String whereString) throws SQLException;
    //Map<Integer,TYPE> getMap(String whereString) throws SQLException;
}
