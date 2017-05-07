package by.it.sorokoee.jd03_02.TestCrud;

import by.it.sorokoee.jd03_02.beans.User;
import by.it.sorokoee.jd03_02.crud.UserCrud;

import java.sql.SQLException;

public class TestUser {
    public static void main(String[] args) throws SQLException {
        UserCrud userCrud=new UserCrud();
        User user=new User(0,"Ltest","Ptest","Etest",2);
        System.out.println(user);
        if (userCrud.create(user))
            System.out.println("CREATE: "+user);
        user=userCrud.read(user);
        if (user!=null)
            System.out.println("READ: "+user);
        user.setEmail("qwerty");
        if (userCrud.update(user))
            System.out.println("UPDATE: "+user);
        if (userCrud.delete(user))
            System.out.println("DELETE: "+user);


    }
}
