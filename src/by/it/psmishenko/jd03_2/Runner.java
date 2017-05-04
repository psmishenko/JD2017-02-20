package by.it.psmishenko.jd03_2;

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
        TestRole.run();
        TestUser.run();
        TestBook.run();
        ShowUsers.showAllUsers();
    }
}
