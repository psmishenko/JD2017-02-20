package by.it.loktev.jd03_03c;

import by.it.loktev.jd03_03c.DAO.UniversalDAO;
import by.it.loktev.jd03_03c.beans.Role;
import by.it.loktev.jd03_03c.beans.User;

import java.sql.SQLException;
import java.util.List;

public class Runner {

    public static void main(String[] args)  {

        try {


            System.out.println("\n=== тестируем\n");

            TestRole.run();

            TestUser.run();

            UniversalDAO<User> userDAO=new UniversalDAO<User>(User.class,"users");
            UniversalDAO<Role> roleDAO=new UniversalDAO<Role>(Role.class,"roles");
            List<User> users=userDAO.getAll("");
            for ( User user : users ){
                int roleid=user.getRoleId();
                Role role=roleDAO.read(roleid);
                System.out.println("Пользователь " +
                        "id=" + user.getId() +
                        " login=" + user.getLogin() +
                        " password=" + user.getPassword() +
                        " email=" + user.getEmail() +
                        " role=" + role.getName()
                        );

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

