package by.it.smirnov.project.java.controller;

import by.it.smirnov.project.java.DAO.DAO;
import by.it.smirnov.project.java.bean.Country;
import by.it.smirnov.project.java.log.SingleLogger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.text.ParseException;

/**
 * Created by aleksey.smirnov on 05.05.2017.
 */
public class CommandActionCountry extends Action{
    private void prepareData(HttpServletRequest request, int id) throws SQLException {
        if (id != 0) {
            DAO dao = DAO.getInstance();
            Country country = dao.getCountry().read(id);
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.setAttribute("country",country);
            }
        }
    }
    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) {
        DAO dao = DAO.getInstance();
        if (FormUtils.isPost(request)) {
            int id = 0;
            try {
                if (request.getParameter("btnDelete")!=null){
                    dao.getCountry().deleteById(FormUtils.getInt(request,"id"));
                    return Actions.COUNTRYS.command;
                } else
                if (request.getParameter("btnEdit")!=null){
                    prepareData(request, FormUtils.getInt(request, "id"));
                    return Actions.ACTIONCOUNTRY.command;
                } else {
                    Country country = new Country();
                    id = FormUtils.getInt(request, "id");
                    country.setId(id);
                    country.setName(FormUtils.getString(request, "name", IPattern.NAME));
                    if (dao.getCountry().save(country))
                        return Actions.COUNTRYS.command;
                    else
                        return null;
                }
            } catch (ParseException|SQLException e) {
                request.setAttribute(IMessages.MSG_ERROR,e.toString());
                SingleLogger.getInstance().error(e.toString());
                try {prepareData(request, id);} catch (Exception ex) {}
            }
        }
        return null;
    }
}