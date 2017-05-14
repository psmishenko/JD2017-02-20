package by.it.ikavalenka.jd03_03.DAO;

import by.it.ikavalenka.jd03_03.beans.Ad;
import by.it.loktev.jd03_02.beans.Role;

import java.util.List;

/**
 * Created by USER on 03.05.2017.
 */
public class testrun {
    public static void main(String[] args) {
        DAO dao =DAO.getInstance();
        dao.user.getAll("");
        List<Ad> ads = dao.ad.getAll("");
        System.out.println(ads);
        List<by.it.ikavalenka.jd03_03.beans.Role> roles = dao.role.getAll("");
        System.out.println(roles);
        List<User> users = dao.user.getAll("");
        System.out.println(users);
    }
}
