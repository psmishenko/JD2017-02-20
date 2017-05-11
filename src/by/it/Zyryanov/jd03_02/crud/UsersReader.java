package by.it.Zyryanov.jd03_02.crud;




import by.it.Zyryanov.jd03_02.beans.Roles;
import by.it.Zyryanov.jd03_02.beans.Users;

import java.sql.SQLException;
import java.util.List;

public class UsersReader {

    public static void read() throws SQLException {

        int userCounter = 0;
        int roleCounter = 0;
        Users_CRUD users_crud = new Users_CRUD();
        Roles_CRUD roles_crud = new Roles_CRUD();

        System.out.println(users_crud.getAll("WHERE ID >= 1").get(0));

        System.out.println("\n Таблица пользователей и их ролей");
        List<Users> users = new Users_CRUD().getAll("");
        System.out.println("===================== Пользователи в БД ====================================================================");
        for (Users each: users){
            userCounter++;
            System.out.println(each);
            System.out.println("Роль: " + roles_crud.getAll("WHERE ID > 1").get(0));
            System.out.println("=====================================================================================================");
        }

        List<Roles> roles = new Roles_CRUD().getAll("");
        for (Roles each: roles){
            roleCounter++;
        }

        System.out.println("ИТОГ: \nКоличество пользователей: " + userCounter + "\nЧисло возможных ролей: " + roleCounter);


    }
}
