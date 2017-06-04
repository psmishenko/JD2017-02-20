package by.it.ikavalenka.jd03_03.DAO;

import by.it.ikavalenka.jd03_01.DB.CN;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by USER on 01.05.2017.
 */
public class Connect {
    public static  Connection connection;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    static Connection getConnection() throws SQLException {
        if (connection==null || connection.isClosed())  {
            synchronized (CN.URL_DB){
                if (connection==null || connection.isClosed())
                    connection=DriverManager.getConnection(CN.URL_DB,CN.USER_DB,CN.PASSWORD_DB);
            }
        }
        return connection;
    }
}
