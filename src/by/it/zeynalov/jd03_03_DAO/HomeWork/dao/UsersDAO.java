package by.it.zeynalov.jd03_03_DAO.HomeWork.dao;


import by.it.zeynalov.jd03_03_DAO.HomeWork.beans.Users;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsersDAO extends AbstractDAO implements InterfaceDAO<Users> {
    public boolean create(Users users) throws SQLException {
        String sql = String.format(
                "INSERT INTO `users`(`Login`, `Password`, `Email`, `FC_rolles`) " +
                        "VALUES ('%s','%s','%s',%d);",
                users.getLogin(), users.getPassword(), users.getEmail(), users.getFc_rolles()
        );
        int id = executeCreate(sql);
        if (id > 0) {
            users.setId(id);
            return true;
        }
        return false;
    }

    public Users read(int id) throws SQLException {
        String whereString = String.format(" Where ID = %d", id);
        List<Users> listUser = getAll(whereString);
        if (listUser.size() == 1) {
            return listUser.get(0);
        }
        return null;
    }

    public boolean update(Users users) throws SQLException {
        String sql = String.format(
                "UPDATE `user` SET " +
                        "`Login`='%s'," +
                        "`Password`='%s'," +
                        "`Email`='%s'," +
                        "`FC_rolles`=%d " +
                        "WHERE ID=%d",
                users.getLogin(),
                users.getPassword(),
                users.getEmail(),
                users.getFc_rolles(),
                users.getId()
        );
        return executeUpdate(sql);
    }

    public boolean delete(Users users) throws SQLException {
        String sql = String.format(
                "DELETE FORM `user` WHERE ID=%d",
                users.getId()
        );
        return executeUpdate(sql);
    }

    @Override
    public List<Users> getAll(String whereString) throws SQLException {
        List<Users> result = new ArrayList<>();
        try (Connection connection = ConnectorCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "SELECT `ID`, `Login`, `Password`, `Email`, `FC_rolles` FROM `users` %s;",
                    whereString
            );
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Users users = new Users(
                        rs.getInt("ID"),
                        rs.getString("Login"),
                        rs.getString("Password"),
                        rs.getString("Email"),
                        rs.getInt("FC_rolles")
                );
                result.add(users);
            }
        }
        return result;
    }
}
