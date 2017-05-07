package by.it.radivonik.jd03_02;

import by.it.radivonik.jd03_01.C_Init;
import by.it.radivonik.jd03_01.C_Reset;
import by.it.radivonik.jd03_02.beans.Role;
import by.it.radivonik.jd03_02.beans.User;
import by.it.radivonik.jd03_02.crud.RoleCRUD;
import by.it.radivonik.jd03_02.crud.UserCRUD;
import by.it.radivonik.jd03_02.dbadmin.DBInit;
import by.it.radivonik.jd03_02.dbadmin.DBReset;

import java.sql.SQLException;

/**
 * Created by Radivonik on 07.05.2017.
 */
public class TaskC {
    public void run() throws SQLException{
        DBReset.exec();
        DBInit.exec();

        RoleCRUD roleCRUD = new RoleCRUD();
        roleCRUD.create(new Role(0, "admin"));
        roleCRUD.create(new Role(0, "buh"));
        roleCRUD.create(new Role(0, "sklad"));
        System.out.println("Роли созданы");

        UserCRUD userCRUD = new UserCRUD();
        Role roleAdmin = roleCRUD.readByName("admin");
        userCRUD.create(new User(0, "radivonik", "admin", "olsy@tut.by", roleAdmin.getId()));
        System.out.println("Пользователи созданы");

        System.out.println("Пересоздание чистой базы данных");
        new C_Reset().run();
        new C_Init().run();
    }
}
