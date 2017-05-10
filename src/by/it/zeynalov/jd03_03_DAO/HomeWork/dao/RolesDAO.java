package by.it.zeynalov.jd03_03_DAO.HomeWork.dao;


import by.it.zeynalov.jd03_03_DAO.HomeWork.beans.Roles;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RolesDAO extends AbstractDAO implements InterfaceDAO<Roles> {
    public boolean create(Roles roles) throws SQLException {
        String sql = String.format(
                "INSERT INTO `roles`(`Title`) " + "VALUES ('%s');",
                roles.getTitle());
        int id = executeCreate(sql);
        if (id > 0) {
            roles.setId(id);
            return true;
        }
        return false;
    }

    public Roles read(int id) throws SQLException {
        String whereString = String.format(
                " WHERE ID=%d", id
        );
        List<Roles> listUsers = getAll(whereString);
        if (listUsers.size() == 1) {
            return listUsers.get(0);
        }
        return null;
    }

    public boolean update(Roles roles) throws SQLException {
        String sql = String.format(
                "UPDATE `roles` SET " +
                        "`Title`='%s'," +
                        "WHERE ID=%d",
                roles.getTitle(),
                roles.getId()
        );
        return executeUpdate(sql);
    }

    public boolean delete(Roles roles) throws SQLException {
        String sql = String.format(
                "DELETE FROM `roles` WHERE ID=%d",
                roles.getId()
        );
        return executeUpdate(sql);
    }

    @Override
    public List<Roles> getAll(String whereString) throws SQLException {
        List<Roles> result = new ArrayList<>();
        try (Connection connection = ConnectorCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "SELECT `ID`, `Title` FROM `roles` %s;",
                    whereString
            );
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Roles roles = new Roles(
                        rs.getInt("ID"),
                        rs.getString("Title")
                );
                result.add(roles);
            }
        }
        return result;
    }
}
