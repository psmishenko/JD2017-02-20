package by.it.Zyryanov.jd03_03.dao;


import by.it.Zyryanov.jd03_03.beans.Books;
import by.it.Zyryanov.jd03_03.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Books_DAO extends AbstractDAO implements interfaceDAO<Books> {


    @Override
    public List<Books> getAll(String WHERE) {

        List<Books> books = new ArrayList<>();
        String sql = "SELECT * FROM Books " + WHERE + ";";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Books book = new Books();
                book.setId(rs.getInt("ID"));
                book.setBooktitle(rs.getString("Booktitle"));
                book.setDescription(rs.getString("Description"));
                book.setAuthor(rs.getString("Author"));
                book.setPrice(rs.getInt("Price"));
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public Books read(int id) {
        List<Books> books = getAll("WHERE ID =" + id + "Limit 0,1");
        if (books.size() > 0) {
            return books.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(Books book) {
        String sql = String.format(
                "INSERT INTO `Books`(`BookTitle`," +
                        " `Description`," +
                        " `Author`, " +
                        "`Price`) VALUES ('%s', '%s', '%s', '%d');",
                book.getBooktitle(),
                book.getDescription(),
                book.getAuthor(),
                book.getPrice()
        );
        book.setId(executeUpdate(sql));
        return (book.getId() > 0);
    }

    @Override
    public boolean update(Books book) {
        String sql = String.format(
                "UPDATE `Books` SET `BookTitle`= %s," +
                        "`Description`= %s," +
                        "`Author`=%s," +
                        "`Price`=%d WHERE ID = %d",
                book.getBooktitle(),
                book.getDescription(),
                book.getAuthor(),
                book.getPrice(),
                book.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(Books book) {
        String sql = String.format(
                "DELETE FROM `Books` WHERE ID = %d",
                book.getId()
        );
        return (0 < executeUpdate(sql));
    }
}
