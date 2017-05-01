package by.it.psmishenko.jd03_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by GN on 01.05.2017.
 */
public class AddData {
    static void AddNewData(String author,String title,int year,String isbn,int lid,int fk_users){
        String sqlAddData =  String.format(" INSERT INTO `books`(`Author`, `Title`, `Year`, `ISBN`, `LID`, `FK_users`) VALUES ('%s','%s',%d,'%s',%d,%d)",
                author,title,year,isbn,lid,fk_users);
       /* try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/
        try (
                Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB)) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sqlAddData);
            System.out.println("Добавлены данные по книге  "+author+" "+title+"LID = "+lid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
