package by.it.vedom.jd03_03;

import java.sql.SQLException;
import java.util.List;

public class Test {
    public static void main(String[] args) throws SQLException {
        DAO dao=DAO.getInstance();
        List<User> users=dao.user.getAll("");
        System.out.println(users);
        List<Role> roles=dao.role.getAll("");
        System.out.println(roles);
        List<Product> products=dao.product.getAll("");
        System.out.println(products);
        List<Order> orders=dao.order.getAll("");
        System.out.println(orders);

    }
}
