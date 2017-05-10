package by.it.zeynalov.jd03_02.homework.test_crud;

import by.it.zeynalov.jd03_02.homework.beans.Role;
import by.it.zeynalov.jd03_02.homework.beans.User;
import by.it.zeynalov.jd03_02.homework.crud.RoleCRUD;
import by.it.zeynalov.jd03_02.homework.crud.TableGenerator;
import by.it.zeynalov.jd03_02.homework.crud.UserCRUD;

import java.sql.SQLException;
import java.util.List;

public class TaskC {
    public static void main(String[] args) throws SQLException {
        TableGenerator tg = new TableGenerator();
        tg.dropAllTables();
        tg.createAllTables();
        tg.prepareData();

        UserCRUD uc = new UserCRUD();
        RoleCRUD rc = new RoleCRUD();
        List<User> users = uc.readAll();
        List<Role> roles = rc.readAll();
        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i) + " " + rc.readById(users.get(i).getFc_rolles()).getTitle());
        }
        System.out.println("----------------------------------------------------------");
        System.out.println("Users Count: " + users.size());
        System.out.println("Role Count: " + roles.size());
    }
}
