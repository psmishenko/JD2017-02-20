//package by.it.Zyryanov.jd03_02.crudBackup;
//
//
//import by.it.Zyryanov.jd03_02_unused.homework.beans.Roles;
//import by.it.Zyryanov.jd03_02_unused.homework.crud.ConnectionCreator;
//
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class Roles_CRUD {
//
//    public boolean create(Roles roles) throws SQLException {
//        try
//                (Connection connection = ConnectionCreator.getConnection();
//                 Statement statement = connection.createStatement()) {
//            String sql = String.format(
//                    "INSERT INTO Roles(Role)\n" +
//                            "values('%s')", roles.getRole()
//            );
//            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
//                ResultSet keys = statement.getGeneratedKeys();
//                if (keys.next()) {
//                    int id = keys.getInt(1);
//                    roles.setId(id);
//                    return true;
//                }
//            }
//            return false;
//        }
//    }
//
//    public Roles read(Roles roles) throws SQLException {
//
//        Roles result = null;
//
//        try (Connection connection = ConnectionCreator.getConnection();
//             Statement statement = connection.createStatement()) {
//            String sql = String.format(
//                    "SELECT ID, Role FROM Roles WHERE ID = '%d'",
//                    roles.getId()
//            );
//            ResultSet rs = statement.executeQuery(sql);
//            if (rs.next()) {
//                result = new Roles(
//                        rs.getInt("ID"),
//                        rs.getString("Role")
//                );
//            }
//        }
//        return result;
//    }
//
//    public boolean update(Roles roles) throws SQLException {
//        try (Connection connection = ConnectionCreator.getConnection();
//             Statement statement = connection.createStatement()) {
//            String sql = String.format(
//                    "UPDATE Roles SET Role = '%s' " +
//                            "WHERE ID = '%d'",
//                    roles.getRole(),
//                    roles.getId()
//            );
//            return (1 == statement.executeUpdate(sql));
//        }
//    }
//
//    public boolean delete(Roles roles) throws SQLException {
//
//        try (Connection connection = ConnectionCreator.getConnection();
//             Statement statement = connection.createStatement()) {
//            String sql = String.format(
//                    "DELETE FROM Roles WHERE ID = '%d'",
//                    roles.getId()
//            );
//            return (1 == statement.executeUpdate(sql));
//        }
//    }
//}
