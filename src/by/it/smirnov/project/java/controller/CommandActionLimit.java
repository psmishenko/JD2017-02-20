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
public class CommandActionLimit extends Action{
    private void prepareData(HttpServletRequest request, int id) throws SQLException {
        if (id != 0) {
            DAO dao = DAO.getInstance();
            Limit limit = dao.getLimit().read(id);
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.setAttribute("limit",limit);
            }
        }
    }
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
            int id = 0;
            try{
                if (request.getParameter("btnDelete")!=null){
                    dao.getLimit().deleteById(FormUtils.getInt(request,"id"));
                    return Actions.LIMITS.command;
                } else
                if (request.getParameter("btnEdit")!=null){
                    prepareData(request, FormUtils.getInt(request, "id"));
                    return Actions.ACTIONLIMIT.command;
                } else {
                    Limit limit=new Limit();
                    id = FormUtils.getInt(request, "id");
                    limit.setId(id);
                    limit.setGroupbank(DAO.getInstance().getGroupBank().read(FormUtils.getInt(request, "idgroupbank")));
                    limit.setOpertype(DAO.getInstance().getOperType().read(FormUtils.getInt(request, "idopertype")));
                    limit.setFromdate(FormUtils.getDate(request, "fromdate"));
                    limit.setSumma(FormUtils.getDouble(request, "summa"));
                    limit.setValut(DAO.getInstance().getValut().read(FormUtils.getInt(request, "idvalut")));
                    limit.setIdsysoper(1);
                    if (dao.getLimit().save(limit))
                        return Actions.LIMITS.command;
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