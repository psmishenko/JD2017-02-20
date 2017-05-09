package by.it.ikavalenka.jd03_01.SQL;

/**
 * Created by USER on 10.05.2017.
 */import java.sql.*;
public class ShowUsers_B {

    public static void main(String[] args) {

        try(Connection connection = DriverManager.getConnection(CN.URL_DB,CN.USER_DB,CN.PASSWORD_DB);
            Statement statementUser = connection.createStatement();
            Statement statementRole = connection.createStatement()){
            ResultSet resultSetUser = statementUser.executeQuery("select * from administrator");
//            ResultSet resultSetUser = statementUser.executeQuery("select * from client");


            while (resultSetUser.next()){
                String user = resultSetUser.getString("Login")+" "+resultSetUser.getString("Catalog");
                int id = resultSetUser.getInt("id");
                ResultSet resultSetRoles = statementRole.executeQuery("select * from role;");
                String role="";
                while (resultSetRoles.next()){
                    if (id==resultSetRoles.getInt("id")){
                        role = resultSetRoles.getString("name");
                        break;
                    }
                }
                System.out.println(user+": "+role);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
