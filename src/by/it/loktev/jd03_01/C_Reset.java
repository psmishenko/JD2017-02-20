package by.it.loktev.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class C_Reset {

    public static void run(Connection connection) throws SQLException {

        C_RunSQL.run(connection,"DROP TABLE IF EXISTS `ads`;");
        C_RunSQL.run(connection,"DROP TABLE IF EXISTS `users`;");
        C_RunSQL.run(connection,"DROP TABLE IF EXISTS `roles`;");

    }
}

