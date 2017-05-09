package by.it.prigozhanov.jd03_02;

import by.it.prigozhanov.jd03_02.crud.ConnectorCreator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by v-omf on 5/1/2017.
 *
 * @author v-omf
 */
public class TaskA {

    public static void main(String[] args) throws SQLException, IOException {
        try (Connection connection = ConnectorCreator.getConnection();
             Statement statement = connection.createStatement();) {
            String login = "Petrov";
            String sql = String.format("SELECT * FROM `users` WHERE Login='%s'", login);
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                System.out.println("Role: "+rs.getString("FK_Roles"));
            }



        }
    }

}
