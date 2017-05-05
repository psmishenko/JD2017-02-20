package by.it.kolenda.jd03_03;
import by.it.kolenda.jd03_03.beans.Ad;
import by.it.kolenda.jd03_03.beans.Role;
import by.it.kolenda.jd03_03.beans.User;
import by.it.kolenda.jd03_03.DAO;

import java.sql.SQLException;
import java.util.List;
/**
 * Created by user on 05.05.2017.
 */
public class Test {
    public static void main(String[] args) throws SQLException {
        DAO dao=DAO.getInstance();
        List<User> users=dao.user.getAll("");
        System.out.println(users);
        List<Role> roles=dao.role.getAll("");
        System.out.println(roles);
        List<Ad> ads=dao.ad.getAll("");
        System.out.println(ads);

    }
}
