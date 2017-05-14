package by.it.smirnov.project.java.controller;

import by.it.smirnov.project.java.DAO.DAO;
import by.it.smirnov.project.java.bean.GroupBank;
import by.it.smirnov.project.java.log.SingleLogger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.text.ParseException;

/**
 * Created by aleksey.smirnov on 05.05.2017.
 */
public class CommandActionGroupBank extends Action{
    private void prepareData(HttpServletRequest request, int id) throws SQLException {
        if (id != 0) {
            DAO dao = DAO.getInstance();
            GroupBank groupBank = dao.getGroupBank().read(id);
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.setAttribute("groupbank",groupBank);
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
                    dao.getGroupBank().deleteById(FormUtils.getInt(request,"id"));
                    return Actions.GROUPBANKS.command;
                } else
                if (request.getParameter("btnEdit")!=null){
                    prepareData(request, FormUtils.getInt(request, "id"));
                    return Actions.ACTIONGROUPBANK.command;
                } else {
                    GroupBank groupBank = new GroupBank();
                    id = FormUtils.getInt(request, "id");
                    groupBank.setId(id);
                    groupBank.setName(FormUtils.getString(request, "name", IPattern.NAME));
                    if (dao.getGroupBank().save(groupBank))
                        return Actions.GROUPBANKS.command;
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