package by.it.Zyryanov.jd03_02_unused.homework.test_crud;


import by.it.Zyryanov.jd03_02_unused.homework.beans.Users;
import by.it.Zyryanov.jd03_02_unused.homework.crud.Users_CRUD;

import java.sql.SQLException;

public class TestUsers {

    public static void main(String[] args) throws SQLException {

        Users_CRUD users_crud = new Users_CRUD();
        Users user = new Users(28, "Petrov28", "password", "petrov@example.com", 2);
        System.out.println(user);

        if (users_crud.create(user)){
            System.out.println("CREATE: " + user);
            user = users_crud.read(user);
        }
        if (user != null) {
            System.out.println("READ: " + user);
        }
        if (users_crud.update(user)){
            System.out.println("UPDATE: " + user);
        }
        if (users_crud.delete(user)){
            System.out.println("DELETE: " + user);
        }
    }


}
