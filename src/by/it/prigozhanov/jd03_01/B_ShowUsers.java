package by.it.prigozhanov.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

/**
 * Created by v-omf on 4/30/2017!
 */
public class B_ShowUsers {

    public static void show() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement = connection.createStatement()) {
            System.out.println("Roles:");
            ResultSet resultSetRole = statement.executeQuery("select * from roles;");
            while (resultSetRole.next()) {
                String out = resultSetRole.getInt("ID") + " - " +
                        resultSetRole.getString("Role");
                System.out.println(out);
            }
            System.out.println("Users:");
            ResultSet resultSet = statement.executeQuery("select * from users;");
            while (resultSet.next()) {
                String out = resultSet.getString("Email") +", "+
                        resultSet.getString("Passport_data") + ", " +
                        resultSet.getString("Login")+ ", " +
                        "Role - " + resultSet.getInt("FK_Roles");
                System.out.println(out);

            }

        } catch (SQLException e) {

        }


    }

}
