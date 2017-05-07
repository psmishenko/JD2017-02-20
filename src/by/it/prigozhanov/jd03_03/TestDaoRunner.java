package by.it.prigozhanov.jd03_03;

import by.it.prigozhanov.jd03_03.beans.Car;
import by.it.prigozhanov.jd03_03.beans.Role;
import by.it.prigozhanov.jd03_03.beans.User;
import by.it.prigozhanov.jd03_03.dao.DAO;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by v-omf on 5/4/2017.
 *
 * @author v-omf
 */
public class TestDaoRunner {
    public static void main(String[] args) throws SQLException {

        DAO dao = DAO.getInstance();
        System.out.println("GET ALL: -----------------");
        List<User> users = dao.user.getAll("");
        System.out.println(users);
        List<Role> roles = dao.role.getAll("");
        System.out.println(roles);
        List<Car> cars = dao.car.getAll("");
        System.out.println(cars);
        System.out.println("GET ALL: -----------------\n");

       // System.out.println(dao.user.getAll("INNER JOIN `roles` ON users.FK_Roles=roles.ID"));
        System.out.println("CRUD: ----------------");
        User user = new User(0, "TestUser", "TestUser", "TestUser", "TestUser", 0, 0);
        dao.user.create(user);
        System.out.println(dao.user.read(user.getId()));
        dao.user.update(new User(user.getId(), "TestUpdate", "TestUpdate", "TestUpdate", "TestUpdate", 1, 1));
        System.out.println(dao.user.read(user.getId()));
        dao.user.delete(user);
        users = dao.user.getAll("");
        System.out.println(users);
        System.out.println("CRUD: ----------------\n");
    }

}
