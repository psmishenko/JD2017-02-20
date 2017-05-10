package by.it.zeynalov.jd03_03_DAO.HomeWork;


import by.it.zeynalov.jd03_03_DAO.HomeWork.beans.Menu;
import by.it.zeynalov.jd03_03_DAO.HomeWork.beans.Roles;
import by.it.zeynalov.jd03_03_DAO.HomeWork.beans.Users;
import by.it.zeynalov.jd03_03_DAO.HomeWork.dao.DAO;

import java.sql.SQLException;
import java.util.List;

public class Test {
    public static void main(String[] args) throws SQLException {
        DAO dao = DAO.getInstance();
        dao.users.create(new Users(22, "login", "qwerty", "test@mail.ru", 40));
        List<Users> users = dao.users.getAll("");
        System.out.println(users);
        List<Roles> roles = dao.roles.getAll("");
        System.out.println(roles);
        List<Menu> menu = dao.menu.getAll("");
        System.out.println(menu);
    }
}
