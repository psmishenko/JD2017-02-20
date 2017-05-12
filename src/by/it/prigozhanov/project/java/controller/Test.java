package by.it.prigozhanov.project.java.controller;


import by.it.prigozhanov.project.java.dao.DAO;

import java.sql.SQLException;

/**
 * Created by v-omf on 5/12/2017.
 *
 * @author v-omf
 */
public class Test {
    public static void main(String[] args) throws SQLException {
        DAO dao = DAO.getInstance();
        System.out.println(dao.car.getAll("WHERE Mark='BMW' OR Model='Panamera'"));
    }
}
