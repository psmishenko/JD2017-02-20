package by.it.akhmelev.project.java.connection;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionCreator {
    static {
        try { //регистрируем драйвер
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        try {
            InitialContext ic=new InitialContext();
            DataSource ds=(DataSource) ic.lookup("java:/comp/env/jdbc/my_sql_akhmelev");
            return ds.getConnection();
        } catch (NamingException e) {
            e.printStackTrace();
            return null;
        }
    }


        //Памятка. Корректно держать настройки соединения вне кода (!)
    /*
    private static final String URL_DB =
            "jdbc:mysql://127.0.0.1:2016/it_academy"
                    + "?useUnicode=true&characterEncoding=UTF-8";
    private static final String USER_DB = "root";
    private static final String PASSWORD_DB = "";
    private static volatile Connection connection = null;


    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed())
            connection = DriverManager.getConnection(
                    URL_DB, USER_DB, PASSWORD_DB
            );
        return connection;
    }

    */




}
