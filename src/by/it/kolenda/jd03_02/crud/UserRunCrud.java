package by.it.kolenda.jd03_02.crud;

import by.it.kolenda.jd03_02.beans.User;

import java.sql.SQLException;

public class UserRunCrud {
    public static void main(String[] args) throws SQLException {
        UserCreateRead userCR=new UserCreateRead();
        UserUpdateDelete userUD=new UserUpdateDelete();
        User user=new User(0,"Ltest","Ptest","Etest",2);
        System.out.println(user);
        if (userCR.create(user))
            System.out.println("CREATE: "+user);
        user=userCR.read(user);
        if (user!=null)
            System.out.println("READ: "+user);
        user.setEmail("Test@mail.ru");
        if (userUD.update(user))
            System.out.println("UPDATE: "+user);
        if (userUD.delete(user))
            System.out.println("DELETE: "+user);

    }
}
