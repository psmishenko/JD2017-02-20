package by.it.prigozhanov.jd03_02.crud;

import by.it.prigozhanov.jd03_02.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by v-omf on 4/29/2017!
 */
public class UserCRUD {
    
    public boolean create(User user) throws SQLException {
        try (Connection connection = ConnectorCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("INSERT INTO `users`(`Passport_data`, `Login`, `Password`, `Email`) VALUES ('%s','%s','%s','%s')",
                            user.getPassportData(), user.getLogin(), user.getPassword(), user.getEmail());
            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet keys = statement.getGeneratedKeys();
                if (keys.next()) {
                    int id = keys.getInt(1);
                    user.setId(id);
                    return true;
                }
            }
            return false;
        }

    }

    public User read(User user) throws SQLException {
        User result = null;
        try (Connection connection = ConnectorCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "SELECT `ID`, `Passport_data`, `Login`, `Password`, `Email`,`FK_Roles`,`FK_Cars` FROM `users` WHERE ID=%d", user.getId());
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) {
                result = new User(
                        rs.getInt("ID"),
                        rs.getString("Passport_data"),
                        rs.getString("Login"),
                        rs.getString("Password"),
                        rs.getString("Email"),
                        rs.getInt("FK_Roles"),
                        rs.getInt("FK_Cars")
                );
            }
        }
        return result;
    }

    public boolean update(User user) throws SQLException {
        try (Connection connection = ConnectorCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("UPDATE `users` SET `Passport_data`='%s',`Login`='%s',`Password`='%s',`Email`='%s',`FK_Roles`='%d',`FK_Cars`='%d' WHERE ID=%d",
                    user.getPassportData(),user.getLogin(),user.getPassword(),user.getEmail(),user.getFkRole(),user.getFkCar(),user.getId());
            return (1 == statement.executeUpdate(sql));
        }
    }

    public boolean delete(User user) throws SQLException {
        try (Connection connection = ConnectorCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("DELETE FROM `users` WHERE ID = %d", user.getId());
            return (1 == statement.executeUpdate(sql));
        }
    }
}
