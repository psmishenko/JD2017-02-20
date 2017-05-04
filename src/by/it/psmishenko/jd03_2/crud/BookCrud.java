package by.it.psmishenko.jd03_2.crud;

import by.it.psmishenko.jd03_2.beans.Book;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by GN on 04.05.2017.
 */
public class BookCrud {
    public   boolean create(Book book) throws SQLException {
        try(Connection connection = ConnectorCreator.getConnection();
            Statement statement = connection.createStatement()){
            String sql = String.format(" INSERT INTO `books`(`Author`, `Title`, `Year`, `ISBN`, `LID`, `FK_users`) " +
                            "VALUES ('%s','%s',%d,'%s',%d,%d)"
                    ,book.getAuthor(),book.getTitle(),book.getYear(),book.getIsbn(),book.getLid(),book.getFk_users());
            if(1==statement.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS)){
                ResultSet keys = statement.getGeneratedKeys();
                if(keys.next()){
                    int id = keys.getInt(1);
                    book.setId(id);
                    return true;
                }
            }
        }
        return false;
    }
    public  boolean update(Book book) throws SQLException {
        try (Connection connection = ConnectorCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "UPDATE `books` SET `Author`='%s',`Title`='%s'," +
                            "`Year`=%d,`ISBN`='%s',`LID`=%d,`FK_users`=%d WHERE `ID`=%d",
                    book.getAuthor(),
                    book.getTitle(),
                    book.getYear(),
                    book.getIsbn(),
                    book.getLid(),
                    book.getFk_users(),
                    book.getId()
            );
            return (1 == statement.executeUpdate(sql));
        }
    }
    public  Book read(Book user) throws SQLException {
        Book resultBook = null;
        try(Connection connection = ConnectorCreator.getConnection();
            Statement statement = connection.createStatement()) {
            String sql = String.format("SELECT `ID`, `Author`, `Title`, `Year`, `ISBN`, `LID`, `FK_users` FROM `books` WHERE ID =  %d "
                    ,user.getId());
            ResultSet rs = statement.executeQuery(sql);
            if(rs.next()){
                resultBook = new Book(rs.getInt("ID"),rs.getString("Author"),rs.getString("Title"),
                        rs.getInt("Year"),rs.getString("ISBN"),rs.getInt("LID"),rs.getInt("FK_users"));
            }
        }
        return resultBook;
    }
    public  boolean delete(Book book) throws SQLException {
        try (Connection connection = ConnectorCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "DELETE FROM `books` WHERE ID=%d",
                    book.getId()
            );
            return (1 == statement.executeUpdate(sql));
        }
    }
}
