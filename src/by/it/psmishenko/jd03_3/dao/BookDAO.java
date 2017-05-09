package by.it.psmishenko.jd03_3.dao;

import by.it.psmishenko.jd03_3.beans.Book;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by GN on 04.05.2017.
 */
public class BookDAO extends AbstractDAO implements InterfaceDAO<Book> {
    private static BookDAO instance;
    private BookDAO() {
    }
     static BookDAO getInstance(){
        if(instance==null) {
            synchronized (RoleDAO.class) {
                if (instance == null) {
                    instance = new BookDAO();
                }
            }
        }
        return instance;
    }

    public   boolean create(Book book) throws SQLException {

            String sql = String.format(" INSERT INTO `books`(`Author`, `Title`, `Year`, `ISBN`, `LID`, `FK_users`) " +
                            "VALUES ('%s','%s',%d,'%s',%d,%d)"
                    ,book.getAuthor(),book.getTitle(),book.getYear(),book.getIsbn(),book.getLid(),book.getFk_users());
        int id = executeCreate(sql);
        if(id>0){
            book.setId(id);
            return true;
        }
        return false;
    }

    public  boolean update(Book book) throws SQLException {
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
            return executeUpdate(sql);
    }

    public  boolean delete(Book book) throws SQLException {
            String sql = String.format("DELETE FROM `books` WHERE ID=%d", book.getId());
            return executeUpdate(sql);
    }

    @Override
    public Book read(int id) throws SQLException {
        String whereString = String.format(" WHERE ID=%d", id);
        List<Book> listBooks = getAll(whereString);
        if (listBooks.size() != 0) {
            return listBooks.get(0);
        }
        return null;
    }

    @Override
    public List<Book> getAll(String whereString) throws SQLException {
        List<Book> res = new ArrayList<>();
        try (Connection connection = ConnectorCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("SELECT `ID`, `Author`, `Title`, `Year`, `ISBN`, `LID`, `FK_users` FROM `books` %s;", whereString);
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Book book = new Book(rs.getInt("ID"), rs.getString("Author"),
                        rs.getString("Title"),
                        rs.getInt("Year"), rs.getString("ISBN"),
                        rs.getInt("LID"), rs.getInt("FK_users"));
                res.add(book);
            }
            return res;
        }
    }
}