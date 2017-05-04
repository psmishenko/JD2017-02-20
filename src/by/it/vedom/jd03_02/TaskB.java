package by.it.vedom.jd03_02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TaskB {

    public static void main(String[] args) throws SQLException {
        StringBuilder sb = new StringBuilder();
        int countUser = 0;
        Connection connection = ConnectorCreator.getConnection();
        ResultSet resultUsers = connection.createStatement().executeQuery(
                "SELECT * FROM users a"
        );
        while (resultUsers.next()) {
            sb.append("Пользователь: " + resultUsers.getString("login"));
            countUser++;
        }
        System.out.println("Количество пользователей: "+countUser);
    }
}
