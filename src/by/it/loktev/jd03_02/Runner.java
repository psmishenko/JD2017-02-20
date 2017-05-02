package by.it.loktev.jd03_02;

import by.it.loktev.jd03_02.test_crud.TestRole;
import by.it.loktev.jd03_02.test_crud.TestUser;

import java.sql.SQLException;

public class Runner {

    public static void main(String[] args)  {

        try {

            System.out.println("\n=== Вариант C\n");

            C_Reset.run();
            System.out.println("База очищена!");

            C_Init.run();
            System.out.println("База наполнена!");

            System.out.println("\n=== Вариант A\n");

            TestRole.run();

            TestUser.run();

            System.out.println("\n=== Вариант B\n");

            TaskB.run();

            //System.out.println("\n=== Вариант C (подготовка)\n");

            //CRUDTest.testUserCRUD();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

