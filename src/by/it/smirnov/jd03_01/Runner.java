package by.it.smirnov.jd03_01;


import java.sql.SQLException;

/**
 * Created by aleksey.smirnov on 28.04.2017.
 */
public class Runner {
    public static void main(String[] args) throws SQLException {
        System.out.println("-------- УДАЛЕНИЕ БД --------");
        try {
            new C_Reset().run();
        }catch (Exception e) {
        }
        System.out.println("-------- СОЗДАНИЕ СТРУКТУРЫ БД --------");
        new C_Init().run();
        System.out.println("-------- ДОБАВЛЕНИЕ СПРАВОЧНИКОВ --------");
        new A_AddSp().run();
        System.out.println("-------- ДОБАВЛЕНИЕ РОЛЕЙ --------");
        new B_AddRoles().run();
        System.out.println("-------- ДОБАВЛЕНИЕ ПОЛЬЗОВАТЕЛЕЙ --------");
        new A_AddUser().run();
        System.out.println("-------- ПЕЧАТЬ ПОЛЬЗОВАТЕЛЕЙ С ПРАВАМИ --------");
        new B_ShowUsers().run();
        System.out.println("-------- ДОБАВЛЕНИЕ ДАННЫХ --------");
        new A_AddData().run();
        System.out.println("-------- БД СОЗДАНА И НАПОЛНЕНА --------");
        //new C_Reset().run();
    }
}
