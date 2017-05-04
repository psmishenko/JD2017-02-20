package by.it.vedom.jd03_01;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
        System.out.println("Добавление ролей");
        new A_AddRole().run();
        System.out.println("Добавление пользователей");
        new A_AddUser().run();
    }
}
