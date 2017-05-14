package by.it.ikavalenka.jd03_01.DB;
import java.sql.*;
/**
 * Created by USER on 09.05.2017.
 */
public class ShowUsers_B {
    public static void main(String[] args) {

        try(Connection connection = DriverManager.getConnection(CN.URL_DB,CN.USER_DB,CN.PASSWORD_DB);
            Statement statementUser = connection.createStatement();
            Statement statementRole = connection.createStatement()){
            ResultSet resultSetUser = statementUser.executeQuery("select * from users;");


            while (resultSetUser.next()){
                String user = resultSetUser.getString("name")+" "+resultSetUser.getString("surname");
                int id = resultSetUser.getInt("id_role");
                ResultSet resultSetRoles = statementRole.executeQuery("select * from role;");
                String role="";
                while (resultSetRoles.next()){
                    if (id==resultSetRoles.getInt("id_role")){
                        role = resultSetRoles.getString("role_type");
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
