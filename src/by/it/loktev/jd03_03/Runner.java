package by.it.loktev.jd03_03;

import by.it.loktev.jd03_03.DAO.RoleDAO;
import by.it.loktev.jd03_03.DAO.UserDAO;
import by.it.loktev.jd03_03.beans.Role;
import by.it.loktev.jd03_03.beans.User;

import java.sql.SQLException;
import java.util.List;

public class Runner {

    public static void main(String[] args)  {

        try {


            System.out.println("\n=== Вариант A\n");

            TestRole.run();

            TestUser.run();

            UserDAO userDAO=new UserDAO();
            RoleDAO roleDAO=new RoleDAO();
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

            //System.out.println("\n=== Вариант B\n");

            //TaskB.run();

            //System.out.println("\n=== Вариант C (подготовка)\n");

            //CRUDTest.testUserCRUD();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

