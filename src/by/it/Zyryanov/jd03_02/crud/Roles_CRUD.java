package by.it.Zyryanov.jd03_02.crud;


import by.it.Zyryanov.jd03_02.beans.Roles;
import by.it.Zyryanov.jd03_02.connection.ConnectionCreator2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Roles_CRUD {



    public List<Roles> getAll(String WHERE) {

        List<Roles> roles = new ArrayList<>();

        String sql = "SELECT * FROM roles " + WHERE + ";";

        try (Connection connection = ConnectionCreator2.getConnection();
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





    public boolean create(Roles roles) throws SQLException {
        try
                (Connection connection = ConnectionCreator2.getConnection();
                 Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "INSERT INTO Roles(Role)\n" +
                            "values('%s')", roles.getRole()
            );
            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet keys = statement.getGeneratedKeys();
                if (keys.next()) {
                    int id = keys.getInt(1);
                    roles.setId(id);
                    return true;
                }
            }
            return false;
        }
    }

    public Roles read(Roles roles) throws SQLException {

        Roles result = null;

        try (Connection connection = ConnectionCreator2.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "SELECT ID, Role FROM Roles WHERE ID = '%d'",
                    roles.getId()
            );
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) {
                result = new Roles(
                        rs.getInt("ID"),
                        rs.getString("Role")
                );
            }
        }
        return result;
    }

    public boolean update(Roles roles) throws SQLException {
        try (Connection connection = ConnectionCreator2.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "UPDATE Roles SET Role = '%s' " +
                            "WHERE ID = '%d'",
                    roles.getRole(),
                    roles.getId()
            );
            return (1 == statement.executeUpdate(sql));
        }
    }

    public boolean delete(Roles roles) throws SQLException {

        try (Connection connection = ConnectionCreator2.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "DELETE FROM Roles WHERE ID = '%d'",
                    roles.getId()
            );
            return (1 == statement.executeUpdate(sql));
        }
    }
}
