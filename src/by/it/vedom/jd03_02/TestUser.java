package by.it.vedom.jd03_02;

import java.sql.SQLException;

public class TestUser {
    public static void main(String[] args) throws SQLException {
        UserCRUD userCRUD=new UserCRUD();
        User user=new User(0,"Ltest","Ptest","Etest",2);
        System.out.println(user);
        if (userCRUD.create(user))
            System.out.println("CREATE: "+user);
        user=userCRUD.read(user);
        if (user!=null)
            System.out.println("READ: "+user);
        user.setEmail("djhfgdkjsgfdasg");
        if (userCRUD.update(user))
            System.out.println("UPDATE: "+user);
        if (userCRUD.delete(user))
            System.out.println("DELETE: "+user);


    }
}
