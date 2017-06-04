package by.it.ikavalenka.project.java.controller;

import by.it.ikavalenka.project.java.beans.administrator;
import by.it.ikavalenka.project.java.beans.client;
import by.it.ikavalenka.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

public class CommandIndex extends Action {
    @Override
    public Action execute(HttpServletRequest request) {
        DAO dao = DAO.getInstance();
        try {
            List<client> clients = dao.clientDAO.getAll("");
            try {
                List<client> clients1 = dao.clientDAO.getAll("");
                request.setAttribute("client", clients1);
            } catch (SQLException e) {
                request.setAttribute(Messages.MSG_ERROR, e.toString());
                e.printStackTrace();
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            List<administrator> administrators = dao.administratorDAO.getAll("");
            try {
                List<administrator> administrators1 = dao.administratorDAO.getAll("");
                request.setAttribute("client", administrators1);
            } catch (SQLException e) {
                request.setAttribute(Messages.MSG_ERROR, e.toString());
                e.printStackTrace();
            }
            return null;
        } catch (SQLException e) {
            request.setAttribute(Messages.MSG_ERROR, e.toString());
            e.printStackTrace();
        }
        return null;
    }
}