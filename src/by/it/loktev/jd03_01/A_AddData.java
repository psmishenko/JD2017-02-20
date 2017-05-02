package by.it.loktev.jd03_01;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class A_AddData {

    public static void run(Connection connection, int floor, int floors, int rooms, String address, String desc, int user) throws SQLException {

            Statement statement=connection.createStatement();
            statement.executeUpdate("INSERT INTO ads (floor, floors, rooms, address, `desc`, userid) VALUES ("+floor+","+floors+","+rooms+",'"+address+"','"+desc+"',"+user+");");
    }

}
