package by.it.radivonik.jd03_03;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Radivonik on 03.05.2017.
 */
public class RoleDAO extends AbstractDAO implements InterfaceDAO {
    @Override
    public boolean create(Object entity) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Object entity) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Object entity) throws SQLException {
        return false;
    }

    @Override
    public List getAll(String where) throws SQLException {
        return null;
    }

    @Override
    public Object read(int id) throws SQLException {
        return null;
    }
}
