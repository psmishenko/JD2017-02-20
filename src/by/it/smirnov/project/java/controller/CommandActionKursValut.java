package by.it.smirnov.project.java.controller;

import by.it.smirnov.project.java.DAO.DAO;
import by.it.smirnov.project.java.bean.*;
import by.it.smirnov.project.java.log.SingleLogger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

/**
 * Created by aleksey.smirnov on 05.05.2017.
 */
public class CommandActionKursValut extends Action{
    private void prepareData(HttpServletRequest request, int id) throws SQLException {
        if (id != 0) {
            DAO dao = DAO.getInstance();
            KursValut kursValut = dao.getKursValut().read(id);
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.setAttribute("kursvalut",kursValut);
            }
        }
    }
    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) {
        DAO dao = DAO.getInstance();

        List<Valut> listValut = null;
        try {
            listValut = dao.getValut().getAll("");
        } catch (SQLException e) {
            SingleLogger.getInstance().error(e.toString());
        }
        request.setAttribute("valuts", listValut);

        if (FormUtils.isPost(request)) {
            int id = 0;
            try{
                if (request.getParameter("btnDelete")!=null){
                    dao.getKursValut().deleteById(FormUtils.getInt(request,"id"));
                    return Actions.KURSVALUTS.command;
                } else
                if (request.getParameter("btnEdit")!=null){
                    prepareData(request, FormUtils.getInt(request, "id"));
                    return Actions.ACTIONKURSVALUT.command;
                } else {
                    KursValut kursValut=new KursValut();
                    id = FormUtils.getInt(request, "id");
                    kursValut.setId(id);
                    kursValut.setDatekurs(FormUtils.getDate(request, "datekurs"));
                    kursValut.setZa(FormUtils.getDouble(request, "za"));
                    kursValut.setZavalut(DAO.getInstance().getValut().read(FormUtils.getInt(request, "zavalut")));
                    kursValut.setDat(FormUtils.getDouble(request, "dat"));
                    kursValut.setDatvalut(DAO.getInstance().getValut().read(FormUtils.getInt(request, "datvalut")));
                    if (dao.getKursValut().save(kursValut))
                        return Actions.KURSVALUTS.command;
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