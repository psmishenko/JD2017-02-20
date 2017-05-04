package by.it.psmishenko.jd03_2;

import by.it.psmishenko.jd03_2.crud.Init;
import by.it.psmishenko.jd03_2.crud.ResetTables;
import by.it.psmishenko.jd03_2.crud.ShowUsers;
import by.it.psmishenko.jd03_2.test_crud.TestBook;
import by.it.psmishenko.jd03_2.test_crud.TestRole;
import by.it.psmishenko.jd03_2.test_crud.TestUser;

import java.sql.SQLException;

/**
 * Created by user on 29.04.2017.
 */
public class Runner {
    public static void main(String[] args) throws SQLException {
        ResetTables.resetAllDB(); //Удаления всех таблиц в вашейбазе данных
        Init.recoveryDB(); // Создания всех таблиц
        //Заполнения таблиц через CRUD операции (прописать заполнение напрямую вызовом конструкторов объектов (beans) с нужными параметрами)
        Init.enterData();
        TestRole.run();
        TestUser.run();
        TestBook.run();
        ShowUsers.showAllUsers();
    }
}
