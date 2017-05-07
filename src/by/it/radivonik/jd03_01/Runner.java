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
            new A_AddData().run();

            System.out.println("\nВариант B");
            new B_AddRoles().run();
            new B_ShowUsers().run();

            System.out.println("\nВариант C");
            new C_Reset().run();
            new C_Init().run();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
