package by.it.ikavalenka.project.java.controller;


import by.it.ikavalenka.project.java.beans.administrator;
import by.it.ikavalenka.project.java.beans.client;
import by.it.ikavalenka.project.java.dao.DAO;

import java.sql.SQLException;

public class Test_simple {
    public static void main(String[] args) throws SQLException {
        DAO dao = DAO.getInstance();
        client client = new client(1, 45, 34, 901, "123.32USD");
        dao.clientDAO.update(client);
    }
}
