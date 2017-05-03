package by.it.loktev.jd03_03;

import java.sql.SQLException;

public class Runner {

    public static void main(String[] args)  {

        try {


            System.out.println("\n=== Вариант A\n");

            TestRole.run();

            TestUser.run();

            //System.out.println("\n=== Вариант B\n");

            //TaskB.run();

            //System.out.println("\n=== Вариант C (подготовка)\n");

            //CRUDTest.testUserCRUD();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

