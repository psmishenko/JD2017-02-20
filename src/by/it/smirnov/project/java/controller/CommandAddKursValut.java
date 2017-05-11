package by.it.smirnov.project.java.controller;

import by.it.smirnov.project.java.DAO.DAO;
import by.it.smirnov.project.java.bean.*;
import by.it.smirnov.project.java.log.SingleLogger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

/**
 * Created by aleksey.smirnov on 05.05.2017.
 */
public class CommandAddKursValut extends Action{
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
            KursValut kursValut=new KursValut();
            try {
                kursValut.setId(0);
                kursValut.setDatekurs(FormUtils.getDate(request,"datekurs"));
                kursValut.setZa(FormUtils.getDouble(request,"za"));
                kursValut.setZavalut(DAO.getInstance().getValut().read(FormUtils.getInt(request,"zavalut")));
                kursValut.setDat(FormUtils.getDouble(request,"dat"));
                kursValut.setDatvalut(DAO.getInstance().getValut().read(FormUtils.getInt(request,"datvalut")));
                if (dao.getKursValut().create(kursValut))
                    return Actions.KURSVALUTS.command;
                else
                    return null;
            } catch (ParseException|SQLException e) {
                request.setAttribute(IMessages.MSG_ERROR,e.toString());
                SingleLogger.getInstance().error(e.toString());
            }
        }
        return null;
    }
}