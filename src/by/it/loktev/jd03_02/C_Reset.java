package by.it.loktev.jd03_02;

import by.it.loktev.jd03_02.crud.ConnectorCreator;

import java.sql.Connection;
import java.sql.SQLException;

public class C_Reset {

    public static void run() throws SQLException {

        Connection connection= ConnectorCreator.getConnection();

        C_RunSQL.run("DROP TABLE IF EXISTS `ads`;");
        C_RunSQL.run("DROP TABLE IF EXISTS `users`;");
        C_RunSQL.run("DROP TABLE IF EXISTS `roles`;");

    }
}

