package by.it.radivonik.jd03_01;

import java.sql.SQLException;

/**
 * Created by Radivonik on 28.04.2017.
 */
public class Runner {
    public static void main(String[] args) {
        try {
            System.out.println("Вариант A");
            new A_AddUser().run();
            System.out.println("Добавлен пользователь");
            new A_AddData().run();
            System.out.println("Добавлены данные");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
