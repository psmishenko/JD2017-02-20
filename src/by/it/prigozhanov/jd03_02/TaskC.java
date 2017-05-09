package by.it.prigozhanov.jd03_02;

import by.it.prigozhanov.jd03_01.C_Init;
import by.it.prigozhanov.jd03_01.C_Reset;
import by.it.prigozhanov.jd03_02.beans.Car;
import by.it.prigozhanov.jd03_02.beans.Role;
import by.it.prigozhanov.jd03_02.beans.User;
import by.it.prigozhanov.jd03_02.crud.CarCRUD;
import by.it.prigozhanov.jd03_02.crud.ConnectorCreator;
import by.it.prigozhanov.jd03_02.crud.RoleCRUD;
import by.it.prigozhanov.jd03_02.crud.UserCRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by v-omf on 5/2/2017.
 *
 * @author v-omf
 */
public class TaskC {


    public static void main(String[] args) throws SQLException {
        //CRUD
        CarCRUD carCRUD = new CarCRUD();
        UserCRUD userCRUD = new UserCRUD();
        RoleCRUD roleCRUD = new RoleCRUD();
        //----

        //взял из задания jd03_01 т.к процесс пересоздания таблицы идентичен.
        C_Reset.reset();
        C_Init.initialize();
        //----

        //наполнение базы
        roleCRUD.create(new Role(0, "Administrator"));
        roleCRUD.create(new Role(0, "Client"));
        System.out.println("roles created!");

        carCRUD.create(new Car(0, "Porsche", "Panamera", 650, "Minsk", 2));
        carCRUD.create(new Car(0, "BMW", "M6", 620, "Minsk", 1));
        carCRUD.create(new Car(0, "Mersedes-benz", "S63", 750, "Minsk", 2));
        System.out.println("cars created!");

        userCRUD.create(new User(0, "None", "Admin", "admin", "None", 1, 0));

        //не понимаю как добавить пустое значение Integer в базу данных поэтому по ка что обновление пользователя может быть только с присваиванием ему машины
        userCRUD.update(new User(1, "None", "Admin", "admin", "None", 1, 1));
        //---

        userCRUD.create(new User(0, "MP2683456", "Petrov", "qwerty", "petrovmail@mail.ru", 2, 0));
        userCRUD.create(new User(0, "MP2643516", "Ivanov", "qwerty", "ivanov1990@mail.ru", 2, 0));
        userCRUD.create(new User(0, "MP2633453", "Sidorov", "qwerty", "sidr1970@mail.ru", 2, 0));
        System.out.println("users added!");





    }


}
