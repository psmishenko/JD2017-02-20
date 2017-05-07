package by.it.sorokoee.jd03_03;

import by.it.sorokoee.jd03_03.beans.Good;
import by.it.sorokoee.jd03_03.beans.Role;
import by.it.sorokoee.jd03_03.beans.User;
import by.it.sorokoee.jd03_03.dao.DAO;

import java.sql.SQLException;
import java.util.List;

public class Test {
    public static void main(String[] args) throws SQLException {
        DAO dao = DAO.getInstance();
        List<User> users = dao.user.getAll("");
        System.out.println(users);
        List<Role> roles = dao.role.getAll("");
        System.out.println(roles);
        List<Good> goods = dao.good.getAll("");
        System.out.println(goods);
    }
}
