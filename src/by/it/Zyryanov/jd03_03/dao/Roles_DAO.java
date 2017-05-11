package by.it.Zyryanov.jd03_03.dao;


import by.it.Zyryanov.jd03_03.beans.Roles;
import by.it.Zyryanov.jd03_03.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Roles_DAO extends AbstractDAO implements interfaceDAO<Roles> {


    @Override
    public List<Roles> getAll(String WHERE) {
        List<Roles> roles = new ArrayList<>();
        String sql = "SELECT * FROM roles " + WHERE + ";";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Roles role = new Roles();
                role.setId(rs.getInt("ID"));
                role.setRole(rs.getString("Role"));
                roles.add(role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roles;
    }

    @Override
    public Roles read(int id) {
        List<Roles> roles = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (roles.size() > 0) {
            return roles.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(Roles role) {
        String sql = String.format(
                "INSERT INTO Roles(Role) VALUES('%s',);", role.getRole()
        );
        role.setId(executeUpdate(sql));
        return (role.getId() > 0);
    }


    @Override
    public boolean update(Roles role) {
        String sql = String.format("UPDATE `roles` SET " +
                        "`role`='%s'," +
                        "WHERE ID=%d",
                role.getRole(),
                role.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(Roles role) {
        String sql = String.format(
                "DELETE FROM Roles WHERE ID = %d",
                role.getId()
        );
        return (0 < executeUpdate(sql));
    }
}
