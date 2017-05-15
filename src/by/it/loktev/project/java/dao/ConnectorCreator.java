package by.it.loktev.project.java.dao;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectorCreator {

    static private Connection connection;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnection() throws SQLException{
        try {
            InitialContext ic= new InitialContext();
            DataSource ds=(DataSource)ic.lookup("java:/comp/env/jdbc/my_sql_loktev");
            return ds.getConnection();
        } catch (NamingException e) {
            e.printStackTrace();
            return null;
        }
    }

    /*
    static public Connection getConnection() throws SQLException {
        if ( connection==null || connection.isClosed() ) {
            synchronized (CN.URL_DB) {
                if ( connection==null || connection.isClosed() ) {
                    connection=DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
                }
            }
        }
        return connection;
    }
*/

}
