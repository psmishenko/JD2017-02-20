package by.it.psmishenko.jd03_2.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by user on 29.04.2017.
 */
public class ConnectorCreator {
   static private Connection connection;
    static {
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e)
        {
            System.out.println("Error loading driver: " + e);
        }
    }

    static Connection getConnection() throws SQLException {
        if(connection==null||connection.isClosed()){
            synchronized (CN.URL_DB) {
                if(connection==null||connection.isClosed())
                connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
            }
        }
        return connection;
    }
}
