package by.it.tereshko.project.java.controller;

import by.it.tereshko.project.java.beans.Ad;
import by.it.tereshko.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

public class CmdIndex extends Action {

    @Override
    public Action execute(HttpServletRequest request) {
        DAO dao = DAO.getInstance();
        try {
            List<Ad> ads = dao.ad.getAll("");
            request.setAttribute("ads", ads);
        } catch (SQLException e) {
            request.setAttribute(Messages.MSG_ERROR, e.toString());
            e.printStackTrace();
        }
        return null;
    }

}