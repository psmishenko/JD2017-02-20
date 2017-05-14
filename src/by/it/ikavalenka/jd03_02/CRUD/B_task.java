package by.it.ikavalenka.jd03_02.CRUD;
import by.it.ikavalenka.jd03_02.CRUD.CN;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by USER on 13.05.2017.
 */
public class B_task {
    public static void main(String[] args) throws SQLException{
        StringBuilder stringBuilder = new StringBuilder();
        int countAll = 0;
        Connection connection = Connect.getConnection();
        ResultSet resultSetAll= connection.createStatement().executeQuery(
                "SELECT * FROM administrator");
        while (resultSetAll.next()){
            stringBuilder.append("Administrator: " + resultSetAll.getString("Login"));
            countAll++;
        }
        System.out.println("Values of administrators is " +countAll);

    }
}
