package by.it.loktev.jd03_02.test_crud;

import by.it.loktev.jd03_02.beans.User;
import by.it.loktev.jd03_02.crud.UserCRUD;

import java.sql.SQLException;

public class TestUser {
    public static void main(String[] args) {
        User user = new User(0, "login", "pass", "email", 2);
        try {

            //проверка CRUD для пользователей

            UserCRUD userCRUD = new UserCRUD();

            //создание
            userCRUD.create(user);
            System.out.println("created: "+user);

            //чтение
            user=userCRUD.read(user);
            System.out.println("readed "+user);

            //обновление
            user.setLogin("loginUpdate");
            userCRUD.update(user);
            user=userCRUD.read(user);
            System.out.println("updated "+user);

            //удаление
            userCRUD.delete(user);
            System.out.println("deleted");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
