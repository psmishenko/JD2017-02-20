package by.it.smirnov.project.java.controller;

import by.it.smirnov.project.java.DAO.DAO;
import by.it.smirnov.project.java.bean.*;
import by.it.smirnov.project.java.log.SingleLogger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.text.ParseException;
import java.sql.Date;
import java.util.List;

/**
 * Created by aleksey.smirnov on 05.05.2017.
 */
public class CommandAddSdel extends Action{
    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) {
        DAO dao = DAO.getInstance();

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

        if (FormUtils.isPost(request)) {
            Sdel sdel=new Sdel();
            try {
                sdel.setId(0);
                sdel.setBank(DAO.getInstance().getBank().read(FormUtils.getInt(request,"idbank")));
                sdel.setSumma(FormUtils.getDouble(request,"summa"));
                sdel.setValut(DAO.getInstance().getValut().read(FormUtils.getInt(request,"idvalut")));
                sdel.setOperType(DAO.getInstance().getOperType().read(FormUtils.getInt(request,"idopertype")));
                sdel.setFromdate(FormUtils.getDate(request,"fromdate"));
                sdel.setTodate(FormUtils.getDate(request,"todate"));
                sdel.setIdsysoper(1);
                sdel.setIdsysoperedit(1);
                if (dao.getSdel().create(sdel))
                    return Actions.SDELS.command;
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