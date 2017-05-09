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
public class CommandAddLimit extends Action{
    @Override
    public Action execute(HttpServletRequest request) {
        DAO dao = DAO.getInstance();
        if (request.getMethod().equalsIgnoreCase("GET")) {
            List<GroupBank> listGroupBank = null;
            List<OperType> listOperType = null;
            List<Valut> listValut = null;
            try {
                listGroupBank = dao.getGroupBank().getAll("");
                listOperType = dao.getOperType().getAll("");
                listValut = dao.getValut().getAll("");
            } catch (SQLException e) {
                SingleLogger.getInstance().error(e.toString());
            }
            request.setAttribute("groupbanks", listGroupBank);
            request.setAttribute("opertypes", listOperType);
            request.setAttribute("valuts", listValut);
            return null;
        }
        if (request.getMethod().equalsIgnoreCase("POST")) {
            Limit limit=new Limit();
            try {
                limit.setId(0);
                limit.setGroupbank(DAO.getInstance().getGroupBank().read(Integer.parseInt(FormUtils.getString(request,"idgroupbank",""))));
                limit.setOpertype(DAO.getInstance().getOperType().read(Integer.parseInt(FormUtils.getString(request,"idopertype",""))));
                limit.setFromdate(Date.valueOf(FormUtils.getString(request,"fromdate","")));
                limit.setSumma(Double.parseDouble(FormUtils.getString(request,"summa","")));
                limit.setValut(DAO.getInstance().getValut().read(Integer.parseInt(FormUtils.getString(request,"idvalut",""))));
                limit.setIdsysoper(1);
                if (dao.getLimit().create(limit))
                    return Actions.LIMITS.command;
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