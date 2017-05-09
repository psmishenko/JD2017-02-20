package by.it.psmishenko.jd03_2.test_crud;

import by.it.psmishenko.jd03_2.beans.User;
import by.it.psmishenko.jd03_2.crud.UserCrud;

import java.sql.SQLException;

/**
 * Created by user on 29.04.2017.
 */
public class TestUser {
    public static void run() throws SQLException {
        UserCrud userCrud = new UserCrud();
        User user = new User(0,"LTest","PTest","ETest",47);
        System.out.println(user);
        if(userCrud.create(user)) System.out.println("Create:"+user.getLogin());
        user = userCrud.read(user);
        if(user!=null) System.out.println("read:"+user.getLogin());
        user.setEmail("vdfvdfvdvdf");
        if(userCrud.update(user)) System.out.println("update:"+user.getLogin()+" Email:"+user.getEmail());
        if(userCrud.delete(user)) System.out.println("delete");

    }
}
