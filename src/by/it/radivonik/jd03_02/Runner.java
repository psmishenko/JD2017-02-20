package by.it.radivonik.jd03_02;

import by.it.radivonik.jd03_02.beans.Role;
import by.it.radivonik.jd03_02.beans.User;
import by.it.radivonik.jd03_02.crud.RoleCRUD;
import by.it.radivonik.jd03_02.crud.UserCRUD;

import java.sql.SQLException;

/**
 * Created by Radivonik on 29.04.2017.
 */
public class Runner {
    public static void main(String[] args) throws SQLException {
//        RoleCRUD roleCRUD = new RoleCRUD();
//        Role role = new Role(0, "Admin");
//        roleCRUD.create(role);

        UserCRUD userCRUD = new UserCRUD();
//        userCRUD.create(new User(0, "alex", "1234", "alex@mail.by", 1));

        User user = new User();
        user.setId(1);
        System.out.println(userCRUD.read(user));
    }
}
