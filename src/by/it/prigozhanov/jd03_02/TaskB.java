package by.it.prigozhanov.jd03_02;

import by.it.prigozhanov.jd03_02.crud.ConnectorCreator;

import java.io.IOException;
import java.sql.*;

/**
 * Created by v-omf on 5/1/2017.
 *
 * @author v-omf
 */
public class TaskB {

    public static void main(String[] args) throws SQLException, IOException {
        try (Connection connection = ConnectorCreator.getConnection();
             Statement statement = connection.createStatement();) {
            ResultSet rs = statement.executeQuery("SELECT * FROM `users` INNER JOIN `roles` ON users.FK_Roles=roles.ID");
            int userCounter = 0;
            while (rs.next()) {
                ResultSetMetaData resultSetMetaData = rs.getMetaData();
                int columnCount = resultSetMetaData.getColumnCount();
                System.out.print("Пользователь:  ");
                userCounter++;
                for (int i = 1; i < columnCount + 1; i++) {
                    if (resultSetMetaData.getColumnLabel(i).equals("Email")) {
                        System.out.print(String.format("%-5s:  %-25s", resultSetMetaData.getColumnLabel(i), rs.getString(i), " "));
                    } else System.out.print(String.format("%-5s:  %-10s", resultSetMetaData.getColumnLabel(i), rs.getString(i), " "));
                }
                System.out.println();

            }
            int roleCounter = 0;
            ResultSet resultSetRole = statement.executeQuery("SELECT * FROM `roles` WHERE 1");
            while (resultSetRole.next()) {
                roleCounter++;
            }

            System.out.println("\nОбщее число пользователей: " + userCounter);
            System.out.println("Общее число ролей: " + roleCounter);
        }
    }

}
