package by.it.smirnov.jd03_02;


import by.it.smirnov.jd03_02.bean.*;
import by.it.smirnov.jd03_02.crud.*;

import java.sql.SQLException;
import java.sql.Timestamp;


/**
 * Created by aleksey.smirnov on 01.05.2017.
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

        CountryCrud cc = new CountryCrud();
        cc.create(new Country(1,"Беларусь"));
        cc.create(new Country(2,"Росиия"));

        GroupBankCrud gbc = new GroupBankCrud();
        gbc.create(new GroupBank(1,"Группа Сбербанк"));
        gbc.create(new GroupBank(2,"Группа Альфа-Банк"));

        System.out.println("-------- ДОБАВЛЕНИЕ РОЛЕЙ --------");

        RoleCrud rc = new RoleCrud();
        rc.create(new Role(1,"Администратор"));
        rc.create(new Role(2,"Пользователь"));
        rc.create(new Role(3,"Гость"));
        rc.create(new Role(4,"Аудитор"));

        System.out.println("-------- ДОБАВЛЕНИЕ ПОЛЬЗОВАТЕЛЕЙ --------");

        UserCrud uc = new UserCrud();
        uc.create(new User(1, "Смирнов А.В.","smirnov_a","smirn"));
        uc.create(new User(2, "Дяго А.А.","smirnovа_a","anna"));

        UserRoleCrud urc = new UserRoleCrud();
        urc.save(new UserRole(0, 1,1));
        urc.save(new UserRole(0, 1,4));
        urc.save(new UserRole(0, 2,1));
        urc.save(new UserRole(0, 2,3));

        System.out.println("-------- ПЕЧАТЬ ПОЛЬЗОВАТЕЛЕЙ С ПРАВАМИ --------");
        new B_ShowUsers().run();
        System.out.println("-------- ДОБАВЛЕНИЕ ДАННЫХ --------");

        SysOperCrud soc = new SysOperCrud();
        soc.create(new SysOper(1, 1, new Timestamp(System.currentTimeMillis())));

        BankCrud bc = new BankCrud();
        Bank bank=new Bank(1,"БПС-Сбербанк", 1, "11-22-33",1,1);
        bc.create(bank);
        System.out.println(bank);
        bank=new Bank(2,"Альфа-Банк", 2, "11-22-44",2,1);
        bc.create(bank);
        System.out.println(bank);
        bank=new Bank(3,"ПАО Сбербанк", 2, "99-88-77",1,1);
        bc.create(bank);
        System.out.println(bank);
        bank=new Bank(4,"Беларусбанк", 1, "11-33-77",1,1);
        bc.create(bank);
        System.out.println(bank);

        System.out.println("-------- РЕДАКТИРОВАНИЕ ДАННЫХ --------");
        int editID = 3;
        bank=bc.readById(editID);
        if (bank!=null) {
            System.out.println(bank);
            bank.setName("Сбербанк");
            bc.update(bank);
            System.out.println(bank);
        } else {
            System.out.println("Банка с ID="+editID+" не найдено");
        }

        System.out.println("-------- УДАЛЕНИЕ ДАННЫХ --------");
        int deleteID = 4;
        if (bc.deleteById(deleteID))
            System.out.println("Банк с ID="+deleteID+" удален");
        System.out.println("-------- БД СОЗДАНА И НАПОЛНЕНА --------");
    }
}
