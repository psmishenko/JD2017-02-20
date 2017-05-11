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
public class CommandAddLimit extends Action{
    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) {
        DAO dao = DAO.getInstance();

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

        if (FormUtils.isPost(request)) {
            Limit limit=new Limit();
            try {
                limit.setId(0);
                limit.setGroupbank(DAO.getInstance().getGroupBank().read(FormUtils.getInt(request,"idgroupbank")));
                limit.setOpertype(DAO.getInstance().getOperType().read(FormUtils.getInt(request,"idopertype")));
                limit.setFromdate(FormUtils.getDate(request,"fromdate"));
                limit.setSumma(FormUtils.getDouble(request,"summa"));
                limit.setValut(DAO.getInstance().getValut().read(FormUtils.getInt(request,"idvalut")));
                limit.setIdsysoper(1);
                if (dao.getLimit().create(limit))
                    return Actions.LIMITS.command;
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