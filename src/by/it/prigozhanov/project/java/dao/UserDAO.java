package by.it.prigozhanov.project.java.dao;

import by.it.prigozhanov.project.java.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by v-omf on 4/29/2017!
 */
public class UserDAO extends AbstractDAO implements InterfaceDAO<User> {

    public boolean create(User user) throws SQLException {
        String sql = String.format("INSERT INTO `users`(`Passport_data`, `Login`, `Password`, `Email`)" +
                        " VALUES ('%s','%s','%s','%s')",
                user.getPassportData(), user.getLogin(), user.getPassword(), user.getEmail());
        int id = executeCreate(sql);
        if (id > 0) {
            user.setId(id);
            return true;
        }
        return false;

    }

    public User read(int id) throws SQLException {
        String whereString = String.format(
                " WHERE ID=%d", id
        );
        List<User> listUsers = getAll(whereString);
        if (listUsers.size() == 1) {
            return listUsers.get(0);
        }
        return null;
    }

    public boolean update(User user) throws SQLException {
        String sql = String.format("UPDATE `users` SET" +
                        " `Passport_data`='%s'," +
                        "`Login`='%s'," +
                        "`Password`='%s'," +
                        "`Email`='%s'," +
                        "`FK_Roles`='%d'," +
                        "`FK_Cars`='%d'" +
                        " WHERE ID=%d",
                user.getPassportData(),
                user.getLogin(),
                user.getPassword(),
                user.getEmail(),
                user.getFkRole(),
                user.getFkCar(),
                user.getId());
        return executeUpdate(sql);
    }

    public boolean delete(User user) throws SQLException {
        String sql = String.format("DELETE FROM `users` WHERE ID = %d",
                user.getId());
        return executeUpdate(sql);
    }

    @Override
    public List<User> getAll(String whereString) throws SQLException {
        List<User> usersList = new ArrayList<>();
        try (Connection connection = ConnectorCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("SELECT `ID`, `Passport_data`, `Login`, `Password`, `Email`, `FK_Roles`, `FK_Cars` FROM `users` %s", whereString);
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                usersList.add(new User(
                        rs.getInt("ID"),
                        rs.getString("Passport_data"),
                        rs.getString("Login"),
                        rs.getString("Password"),
                        rs.getString("Email"),
                        rs.getInt("FK_Roles"),
                        rs.getInt("FK_Cars")
                ));
            }


        }
        return usersList;
    }
}
