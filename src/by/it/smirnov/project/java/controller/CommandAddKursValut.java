package by.it.smirnov.project.java.controller;

import by.it.smirnov.project.java.DAO.DAO;
import by.it.smirnov.project.java.bean.*;
import by.it.smirnov.project.java.log.SingleLogger;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

/**
 * Created by aleksey.smirnov on 05.05.2017.
 */
public class CommandAddKursValut extends Action{
    @Override
    public Action execute(HttpServletRequest request) {
        DAO dao = DAO.getInstance();
        if (request.getMethod().equalsIgnoreCase("GET")) {
            List<Valut> listValut = null;
            try {
                listValut = dao.getValut().getAll("");
            } catch (SQLException e) {
                SingleLogger.getInstance().error(e.toString());
            }
            request.setAttribute("valuts", listValut);
            return null;
        }
        if (request.getMethod().equalsIgnoreCase("POST")) {
            KursValut kursValut=new KursValut();
            try {
                kursValut.setId(0);
                kursValut.setDatekurs(Date.valueOf(FormUtils.getString(request,"datekurs","")));
                kursValut.setZa(Double.parseDouble(FormUtils.getString(request,"za","")));
                kursValut.setZavalut(DAO.getInstance().getValut().read(Integer.parseInt(FormUtils.getString(request,"zavalut",""))));
                kursValut.setDat(Double.parseDouble(FormUtils.getString(request,"dat","")));
                kursValut.setDatvalut(DAO.getInstance().getValut().read(Integer.parseInt(FormUtils.getString(request,"datvalut",""))));
                if (dao.getKursValut().create(kursValut))
                    return Actions.KURSVALUTS.command;
                else
                    return null;
            } catch (ParseException|SQLException e) {
                SingleLogger.getInstance().error(e.toString());
                return Actions.ERROR.command;
            }

        }
        return null;
    }
}