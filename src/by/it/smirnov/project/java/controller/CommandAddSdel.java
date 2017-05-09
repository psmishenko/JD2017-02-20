package by.it.smirnov.project.java.controller;

import by.it.smirnov.project.java.DAO.DAO;
import by.it.smirnov.project.java.bean.*;
import by.it.smirnov.project.java.log.SingleLogger;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;
import java.sql.Date;
import java.util.List;

/**
 * Created by aleksey.smirnov on 05.05.2017.
 */
public class CommandAddSdel extends Action{
    @Override
    public Action execute(HttpServletRequest request) {
        DAO dao = DAO.getInstance();
        if (request.getMethod().equalsIgnoreCase("GET")) {
            List<Bank> listBank = null;
            List<Valut> listValut = null;
            List<OperType> listOperType = null;
            try {
                listBank = dao.getBank().getAll("");
                listValut = dao.getValut().getAll("");
                listOperType = dao.getOperType().getAll("");
            } catch (SQLException e) {
                SingleLogger.getInstance().error(e.toString());
            }
            request.setAttribute("banks", listBank);
            request.setAttribute("valuts", listValut);
            request.setAttribute("opertypes", listOperType);
            return null;
        }
        if (request.getMethod().equalsIgnoreCase("POST")) {
            Sdel sdel=new Sdel();
            try {
                sdel.setId(0);
                sdel.setBank(DAO.getInstance().getBank().read(Integer.parseInt(FormUtils.getString(request,"idbank",""))));
                sdel.setSumma(Double.parseDouble(FormUtils.getString(request,"summa","")));
                sdel.setValut(DAO.getInstance().getValut().read(Integer.parseInt(FormUtils.getString(request,"idvalut",""))));
                sdel.setOperType(DAO.getInstance().getOperType().read(Integer.parseInt(FormUtils.getString(request,"idopertype",""))));
                sdel.setFromdate(Date.valueOf(FormUtils.getString(request,"fromdate","")));
                sdel.setTodate(Date.valueOf(FormUtils.getString(request,"todate","")));
                sdel.setIdsysoper(1);
                sdel.setIdsysoperedit(1);
                if (dao.getSdel().create(sdel))
                    return Actions.SDELS.command;
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