package by.it.radivonik.project.java.connection;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Radivonik on 04.05.2017.
 */
public class ConnectionCreator {
    static private Connection connection;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        try {
            InitialContext context = new InitialContext();
            DataSource ds = (DataSource) context.lookup("java:/comp/env/jdbc/my_sql_radivonik");
            return ds.getConnection();
        }
        catch (NamingException e) {
            e.printStackTrace();
        }
        return null;
    }
/*
    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            synchronized (CN.URL_DB) {
                connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
            }
        }
        return connection;
    }
*/
}
