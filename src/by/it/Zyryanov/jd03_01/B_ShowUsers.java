package by.it.Zyryanov.jd03_01;




import java.sql.*;

public class B_ShowUsers {
    public static void show() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }

        try (
                Connection connection =
                        DriverManager.getConnection(CN.URL_DB2, CN.USER_DB, CN.PASSWORD_DB);
        ) {
            Statement statement = connection.createStatement();
            Statement statement1 = connection.createStatement();
            ResultSet set = statement.executeQuery("SELECT * FROM users JOIN roles ON users.fk_roles = roles.id;");
            ResultSet set1 = statement1.executeQuery("SELECT * FROM Books");

            System.out.println("--------------------Printing all existing USERS--------------------");
            while (set.next()){
                String out = set.getString("Email") + " , " + set.getString("Login") + " , " + set.getString("Role");
                System.out.println(out);
            }
            System.out.println("--------------------Printing all existing BOOKS--------------------");
            while (set1.next()){
                String out = set1.getString("BookTitle") +  " , " + set1.getString("Price");
                System.out.println(out);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }




    }
}
