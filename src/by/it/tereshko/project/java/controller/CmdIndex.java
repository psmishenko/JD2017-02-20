package by.it.tereshko.project.java.controller;

import by.it.tereshko.project.java.beans.Ad;
import by.it.tereshko.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class CmdIndex extends Action {

    @Override
    public Action execute(HttpServletRequest request) {

        int start = 0;
        if (request.getParameter("start") != null) {
            try {
                start = Form.getInt(request, "start");
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        DAO dao = DAO.getInstance();
        try {
            int adCount = dao.ad.getAll("").size();
            request.setAttribute("adCount", adCount);
            String limit = String.format(" ORDER BY ID LIMIT %d,10 ", start);
            List<Ad> ads = dao.ad.getAll(limit);
            request.setAttribute("ads", ads);
        } catch (SQLException e) {
            request.setAttribute(Messages.MSG_ERROR, e.toString());
            e.printStackTrace();
        }
        return null;
    }

}