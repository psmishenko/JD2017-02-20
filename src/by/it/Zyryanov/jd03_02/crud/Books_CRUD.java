package by.it.Zyryanov.jd03_02.crud;


import by.it.Zyryanov.jd03_02.beans.Books;
import by.it.Zyryanov.jd03_02.connection.ConnectionCreator2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Books_CRUD {

    public boolean create(Books books) throws SQLException {

        try (Connection connection = ConnectionCreator2.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "INSERT INTO `Books`(`BookTitle`," +
                            " `Description`," +
                            " `Author`, " +
                            "`Price`) VALUES ('%s', '%s', '%s', '%d');",
                    books.getBooktitle(),
                    books.getDescription(),
                    books.getAuthor(),
                    books.getPrice()
            );
            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet keys = statement.getGeneratedKeys();
                if (keys.next()) {
                    int id = keys.getInt(1);
                    books.setId(id);
                    return true;
                }
            }
            return false;
        }
    }

    public Books read(Books books) throws SQLException {

        Books result = null;

        try (Connection connection = ConnectionCreator2.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(

                    "SELECT `id`, " +
                            "`BookTitle`," +
                            " `Description`, " +
                            "`Author`, " +
                            "`Price` FROM `Books` WHERE ID = %d", books.getId()
            );
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) {
                result = new Books(
                        rs.getInt("ID"),
                        rs.getString("BookTitle"),
                        rs.getString("Description"),
                        rs.getString("Author"),
                        rs.getInt("Price")
                );
            }
        }
        return result;
    }


    public boolean update(Books books) throws SQLException {

        try (Connection connection = ConnectionCreator2.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(

                    "UPDATE `Books` SET `BookTitle`= %s," +
                            "`Description`= %s," +
                            "`Author`=%s," +
                            "`Price`=%d WHERE ID = %d",
                    books.getBooktitle(),
                    books.getDescription(),
                    books.getAuthor(),
                    books.getPrice(),
                    books.getId()
            );
            return (1 == statement.executeUpdate(sql));
        }
    }

    public boolean delete(Books books) throws SQLException {

        try (Connection connection = ConnectionCreator2.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "DELETE FROM `Books` WHERE ID = %d",
                    books.getId()
            );
            return (1 == statement.executeUpdate(sql));
        }
    }
}
