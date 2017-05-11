package by.it.Zyryanov.jd03_03;


import by.it.Zyryanov.jd03_03.beans.Roles;
import by.it.Zyryanov.jd03_03.beans.Users;
import by.it.Zyryanov.jd03_03.dao.DAO;
import by.it.Zyryanov.jd03_03.dao.Users_DAO;

import java.sql.SQLException;
import java.util.List;

public class Runner_Users {


    private static void showUsers() {
        System.out.println("\n Таблица пользователей");
        List<Users> users = new Users_DAO().getAll("");
        System.out.println("===================== Пользователи в БД ====================================================================");
        for (Users each : users) {
            System.out.println(each);
            System.out.println("=====================================================================================================");
        }
    }


    public static void main(String[] args) throws SQLException {

        DAO dao = DAO.getDao();

        System.out.println("Роли пользователей");
        for (Roles each : dao.role.getAll("")) {
            System.out.println(each);
        }
        showUsers();

        Users user = new Users(0, "ivan", "password", "ivan@mail.ru", 2);

        if (dao.user.create(user)) System.out.println("\n Добавлен: " + user);
        showUsers();

        user = dao.user.getAll("WHERE ID > 1").get(0);
        user.setLogin("ivan_Petrov");
        if (dao.user.update(user)) System.out.println("\nИзменен: " + user);
        showUsers();

        if (dao.user.delete(user)) System.out.println("\nУдалён: " + user);
        showUsers();
    }
}