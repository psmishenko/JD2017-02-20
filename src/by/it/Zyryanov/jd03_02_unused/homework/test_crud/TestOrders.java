package by.it.Zyryanov.jd03_02_unused.homework.test_crud;


import by.it.Zyryanov.jd03_02_unused.homework.beans.Orders;
import by.it.Zyryanov.jd03_02_unused.homework.crud.Orders_CRUD;

import java.sql.SQLException;

public class TestOrders {

    public static void main(String[] args) throws SQLException {

        Orders_CRUD orders_crud = new Orders_CRUD();
        Orders order = new Orders(0, 1, 1);
        System.out.println(order);

        if (orders_crud.create(order)){
            System.out.println("CREATE: " + order);
            orders_crud.read(order);
        }

        if (order != null) {
            System.out.println("READ: " + order);
        }

        if (orders_crud.update(order)){
            System.out.println("UPDATE: " + order);
        }
        if (orders_crud.delete(order)){
            System.out.println("DELETE: " + order);
        }


    }

}
