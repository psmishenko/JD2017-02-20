package by.it.ikavalenka.jd03_01.DB;
import java.sql.*;
/**
 * Created by USER on 01.05.2017.
 */
public class DB_create {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        try(Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
        ){
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO `administrator`(`Login`, `Password`, `Catalog`, `FullOrder_id`, `blacklist_Black_list_ID`)" +
                    "VALUES (123,'123','CatalogOne',567,980);");
//            statement.executeUpdate("INSERT INTO `client`(`Login`, `Password`, `MadeOrder`, `PayOrder`)" +
//                    "VALUES (456,'456','OrderOne',980);");

            System.out.println("Database was created");


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
