package by.it.smirnov.project.java.Connection;

import by.it.smirnov.project.java.log.SingleLogger;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectorCreator {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            SingleLogger.getInstance().error(e.toString());
        }
    }

    public static Connection getConnection() throws SQLException {
        try {
            InitialContext ic=new InitialContext();
            DataSource ds=(DataSource) ic.lookup("java:/comp/env/jdbc/my_sql_smirnov");
            return ds.getConnection();
        } catch (NamingException e) {
            e.printStackTrace();
            return null;
        }
    }

    /*
    private static volatile Connection connection = null;

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            synchronized (ConnectionInfo.URL_DB) {
                if (connection == null || connection.isClosed())
                    connection = DriverManager.getConnection(
                            ConnectionInfo.URL_DB,
                            ConnectionInfo.USER_DB,
                            ConnectionInfo.PASSWORD_DB
                    );
            }
        }
        return connection;
    }
  */
}
