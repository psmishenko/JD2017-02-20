package by.it.smirnov.project.java.controller;

import by.it.smirnov.project.java.DAO.DAO;
import by.it.smirnov.project.java.bean.Valut;
import by.it.smirnov.project.java.log.SingleLogger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.text.ParseException;

/**
 * Created by aleksey.smirnov on 05.05.2017.
 */
public class CommandActionValut extends Action{
    private void prepareData(HttpServletRequest request, int id) throws SQLException {
        if (id != 0) {
            DAO dao = DAO.getInstance();
            Valut valut = dao.getValut().read(id);
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.setAttribute("valut",valut);
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
                    dao.getValut().deleteById(FormUtils.getInt(request,"id"));
                    return Actions.VALUTS.command;
                } else
                if (request.getParameter("btnEdit")!=null){
                    prepareData(request, FormUtils.getInt(request, "id"));
                    return Actions.ACTIONVALUT.command;
                } else {
                    Valut valut=new Valut();
                    id = FormUtils.getInt(request, "id");
                    valut.setId(id);
                    valut.setNamesokr(FormUtils.getString(request, "namesokr", IPattern.VALUT));
                    valut.setNamefull(FormUtils.getString(request, "namefull", IPattern.NAME));
                    if (dao.getValut().save(valut))
                        return Actions.VALUTS.command;
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